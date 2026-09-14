class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();
        //create empty stack to push indices of elements

        for(int i =0; i< heights.length ; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                    //pop index
                    int poppedIndex = st.pop();

                    int height = heights[poppedIndex];

                    int width;

                    if(st.isEmpty()){
                        width=i;
                    }
                    else{
                        width = i - st.peek() -1;
                    }

                    int area = height * width;

                    maxArea = Math.max(maxArea,area);
            }
                
                //push current index
            st.push(i);
            
        }

        int n = heights.length;

        while(!st.isEmpty()){
            int poppedIndex = st.pop();
            int height = heights[poppedIndex];
            int width;

            if(st.isEmpty()){
                width = n;
            }
            else{
                width = n - st.peek() - 1;
            }

            int area = height * width;
            maxArea = Math.max(maxArea , area);
        

        }

        return maxArea;
        
    }
}