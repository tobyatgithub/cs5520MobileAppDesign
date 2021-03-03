package edu.neu.madcourse.numad2021spring_fangyuanhuang;

public class LinkCollectorItemCard implements ItemClickListener {
    private final String itemName;
    private final String itemURL;

    public LinkCollectorItemCard(String itemName, String itemURL) {
        this.itemName = itemName;
        this.itemURL = itemURL;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemURL() {
        return itemURL;
    }

    @Override
    public void onItemClick(int position) {
        // TODO: link to website
    }
}
