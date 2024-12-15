class Solution {
       // Approach
        // store the initial pass ratio
        // Then for every extraStudent you have add a new student to all passration or intial students because greedy           // solution don't work here everytime you have check for all students 
        // so you will create a new array updatedpassration where you add the count of + 1 to all the pasration 
        // then in this you take the index with the max difference 
        // then you will update it 
        // repeat the process for all extraStudent
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0] , a[0]));
       
        
        for(int i=0;i<n;i++) {
            double currRatio = (double) classes[i][0] / classes[i][1];
            double updatedRatio = (double)(classes[i][0] + 1) / (classes[i][1] + 1);
            
            double diff = updatedRatio-currRatio;
            pq.offer(new double[] { diff , i});
        }
        
        while(extraStudents-- > 0) {
            
            double element[] = pq.poll();
            
            int idx = (int) element[1];
            
            classes[idx][0]++;
            classes[idx][1]++;
            
            double currPR = (double) classes[idx][0] / classes[idx][1];
            double updatedPR = (double)(classes[idx][0] + 1) / (classes[idx][1] + 1);
            
            double delta = updatedPR-currPR;
            
            pq.offer(new double[] { delta , idx});
            
        }
        
        double result = 0;
        for(int i=0;i<n;i++) {
            result += (double) classes[i][0] / classes[i][1];
        }
        
        return result/n;
    }
}