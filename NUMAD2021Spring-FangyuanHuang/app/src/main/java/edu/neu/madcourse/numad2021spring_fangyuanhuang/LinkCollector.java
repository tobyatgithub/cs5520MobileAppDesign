package edu.neu.madcourse.numad2021spring_fangyuanhuang;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class LinkCollector extends AppCompatActivity {
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";
    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private ArrayList<LinkCollectorItemCard> itemList = new ArrayList<LinkCollectorItemCard>();
    private RecyclerView recyclerView;
    private LinkCollectorViewAdapter rviewAdapter;
    private RecyclerView.LayoutManager rLayoutManager;
    private FloatingActionButton addButton;
//
//    private FloatingActionButton fab;
//    ArrayAdapter<String> adapter;
//    private ListView myListView;
//    private String m_Text = "";

//    @Override
//    protected void onStart() {
//        super.onStart();
//        myListView = findViewById(R.id.listView);
//        adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,
//                listItems);
//        myListView.setAdapter(adapter);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkcollect);

        init(savedInstanceState);

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = 0;
                addItem(pos);
            }
        });
//        fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                addListItem();
//                Snackbar.make(view, "Item added to list",
//                        Snackbar.LENGTH_LONG).setAction("Action", null).show();
//            }
//        });
    }

    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void initialItemData(Bundle savedInstanceState) {
        // not the first time to open this activity
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);

            for (int i = 0; i < size; i++) {
                Integer imgId = savedInstanceState.getInt(KEY_OF_INSTANCE + i + "0");
                String ItemName = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");
                String ItemURL =  savedInstanceState.getString(KEY_OF_INSTANCE + i + "2");

                LinkCollectorItemCard itemCard = new LinkCollectorItemCard(ItemName, ItemURL);
                itemList.add(itemCard);
            }
        }
        // first time to open this activity
        else {
            // TODO: seems not needed in our case.
        }

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
        builder.setTitle("title");

        LayoutInflater factory = LayoutInflater.from(this);
        final View textEntryView = factory.inflate(R.layout.item_card, null);
        final EditText nameInput = (EditText) textEntryView.findViewById(R.id.item_name);
        final EditText urlInput = (EditText) textEntryView.findViewById(R.id.item_url);
        nameInput.setInputType(InputType.TYPE_CLASS_TEXT);
        urlInput.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
        urlInput.setLinksClickable(true);
        builder.setView(textEntryView);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nameText = nameInput.getText().toString();
                String urlText = urlInput.getText().toString();
                LinkCollectorItemCard itemCard = new LinkCollectorItemCard(nameText, urlText);
                itemList.add(position, itemCard);
                rviewAdapter.notifyDataSetChanged();
                Toast.makeText(LinkCollector.this, "Add an item", Toast.LENGTH_SHORT).show();
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
