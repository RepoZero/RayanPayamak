package ir.rayanpayamak.Models;

import java.util.ArrayList;

/**
 * Created by cloner on 7/15/17.
 */

public class SectionDataModel {


        private String headerTitle;
        private ArrayList<SingleItemModel> allItemsInSection;


        public SectionDataModel() {

        }
        public SectionDataModel(String headerTitle, ArrayList<SingleItemModel> allItemsInSection) {
            this.headerTitle = headerTitle;
            this.allItemsInSection = allItemsInSection;
        }



        public String getHeaderTitle() {
            return headerTitle;
        }

        public void setHeaderTitle(String headerTitle) {
            this.headerTitle = headerTitle;
        }

        public ArrayList<SingleItemModel> getAllItemsInSection() {
            return allItemsInSection;
        }

        public void setAllItemsInSection(ArrayList<SingleItemModel> allItemsInSection) {
            this.allItemsInSection = allItemsInSection;
        }
}
