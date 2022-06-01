class BrowserHistory {

    int pageIndex = 0;
    int currIndex = 0;
    Map<Integer, String> history = new HashMap<Integer, String>();
    
    public BrowserHistory(String homepage) {
        history.put(pageIndex, homepage);
        currIndex = pageIndex;
    }
    
    public void visit(String url) {
        while(currIndex < pageIndex){
            history.remove(pageIndex);
            pageIndex--;
            
        }

        history.put(++pageIndex, url);
        currIndex = pageIndex;
    }
    
    public String back(int steps) {
        // if(currIndex - steps < 0)
        //     return history.get(0);
        // currIndex = currIndex - steps;
        // return history.get(currIndex);
        
        while(steps > 0 && currIndex > 0){
            currIndex--;
            steps--;
        }
        return history.get(currIndex);
    }
    
    public String forward(int steps) {
//         if(currIndex + steps > pageIndex)
//             return history.get(pageIndex);
//         currIndex = currIndex + steps;

//         return history.get(currIndex);
        
        
        while (steps > 0 && currIndex < pageIndex) {
            steps--;
            currIndex++;
        }
        return history.get(currIndex);
    }
}

// /**
//  * Your BrowserHistory object will be instantiated and called as such:
//  * BrowserHistory obj = new BrowserHistory(homepage);
//  * obj.visit(url);
//  * String param_2 = obj.back(steps);
//  * String param_3 = obj.forward(steps);
//  */


// class BrowserHistory {
    
//     private List<String> history;
//     private int ptr;
    
//     public BrowserHistory(String homepage) {
//         ptr = 0;
//         history = new ArrayList<String>();
//         history.add(homepage);
//     }
    
//     public void visit(String url) {
//         int index = history.size() - 1;
//         while (ptr < index) {
//             history.remove(index);
//             index--;
//         }
//         history.add(url);
//         ptr++;
//     }
    
//     public String back(int steps) {
//         while (steps > 0 && ptr > 0) {
//             steps--;
//             ptr--;
//         }
//         return history.get(ptr);
//     }
    
//     public String forward(int steps) {
//         while (steps > 0 && ptr < history.size() - 1) {
//             steps--;
//             ptr++;
//         }
//         return history.get(ptr);
//     }   
// }