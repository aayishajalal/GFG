class Solution {
    
    static class Item{
        int val, wt; 
        double ratio=0.0; 
        Item(int val, int wt){
            this.val = val;
            this.wt = wt;
            this.ratio = (double)val/wt;
        }
    }
    double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double totalVal=0.0;
       //list of items
       List<Item> items = new ArrayList<>();
       //add items to list
       for(int i=0; i<val.length; i++){
           items.add(new Item(val[i],wt[i]));
       }
       //sort desc based on ratio
       items.sort((a,b)->Double.compare(b.ratio,a.ratio));
       //take whole or fraction
       for(Item item:items){
           //take whole
           if(item.wt<=capacity){
               capacity-=item.wt;
               totalVal+=item.val;
           }else{
               double fraction = (double) capacity/item.wt;
               totalVal+=item.val*fraction;
               break;
           }
       }
       return totalVal;
    }
}