package com.example;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.ListCompareAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JaversExample {


    static class Item {
        private String id;
        private String value;
        private boolean check;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if (check != item.check) return false;
            if (id != null ? !id.equals(item.id) : item.id != null) return false;
            return value != null ? value.equals(item.value) : item.value == null;
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (check ? 1 : 0);
            return result;
        }
    }


    public static void main(String[] args) {

        Javers javers = JaversBuilder.javers()
                .withListCompareAlgorithm(ListCompareAlgorithm.SIMPLE)
                .build();


        Item item1 = new Item();
        item1.setId("itemid1");
        item1.setValue("ITEM_VALUE");
        item1.setCheck(false);

        Item item2 = new Item();
        item1.setId("itemid2");
        item1.setValue("ITEM_VALUE2");
        item1.setCheck(false);

        Item item3 = new Item();
        item1.setId("itemid3");
        item1.setValue("ITEM_VALUE_4");
        item1.setCheck(false);


        Item item4 = new Item();
        item1.setId("itemid1");
        item1.setValue("ITEM_VALUE");
        item1.setCheck(true);

        Item item5 = new Item();
        item1.setId("itemid2");
        item1.setValue("ITEM_VALUE2");
        item1.setCheck(true);

        Item item6 = new Item();
        item1.setId("itemid3");
        item1.setValue("ITEM_VALUE_4");
        item1.setCheck(true);

        Item item7 = new Item();
        item1.setId("itemid3");
        item1.setValue("ITEM_VALUE_5");
        item1.setCheck(true);


        List<Item> left = Arrays.asList(item1, item2, item3);

        List<Item> right = Arrays.asList(item4, item5, item6, item7);

        Diff diff = javers.compareCollections(left, right, Item.class);

        System.out.println(diff);


    }
}
