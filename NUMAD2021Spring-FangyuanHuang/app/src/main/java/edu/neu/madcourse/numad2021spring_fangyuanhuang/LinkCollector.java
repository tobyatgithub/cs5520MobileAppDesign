package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity {
    private ArrayList<LinkCollectorItemCard> itemList = new ArrayList<LinkCollectorItemCard>();
    private RecyclerView recyclerView;
    private LinkCollectorViewAdapter rviewAdapter;
    private RecyclerView.LayoutManager rLayoutManager;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkcollect);

        createRecyclerView();

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = 0;
                addItem(pos);
            }
        });
    }

    private void createRecyclerView() {
        rLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        rviewAdapter = new LinkCollectorViewAdapter(itemList);
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemList.get(position).onItemClick(position);
                rviewAdapter.notifyItemChanged(position);
            }
        };
        rviewAdapter.setOnItemClickListener(itemClickListener);

        recyclerView.setAdapter(rviewAdapter);
        recyclerView.setLayoutManager(rLayoutManager);
    }


    private void addItem(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add a website with its URL");

        // two input layout
        LinearLayout textEntryView = new LinearLayout(this);
        textEntryView.setOrientation(LinearLayout.VERTICAL);
        final EditText nameInput = new EditText(this);
        final EditText urlInput = new EditText(this);
        nameInput.setInputType(InputType.TYPE_CLASS_TEXT);
        nameInput.setHint("Type in name");
        urlInput.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
        urlInput.setHint("Type in URL");
        urlInput.setLinksClickable(true);
        textEntryView.addView(nameInput);
        textEntryView.addView(urlInput);
        builder.setView(textEntryView);

        // onClick OK
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nameText = nameInput.getText().toString();
                String urlText = urlInput.getText().toString();
                //check urlText format
                if (Patterns.WEB_URL.matcher(urlText).matches()) {
                    LinkCollectorItemCard itemCard = new LinkCollectorItemCard(nameText, urlText);
                    itemList.add(position, itemCard);
                    Toast.makeText(LinkCollector.this, "Added a website", Toast.LENGTH_SHORT).show();
                    rviewAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(LinkCollector.this, "ERROR: Please enter a valid URL", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
