
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*time = distance / speed
        distance = target - position

        time = (target - position) / speed
        target = 10
        position = [2,6] //2 cars
        speed = [2,1] 

        car A time = 10 - 2 / 2 = 4
        car B time = 10 - 6 / 1 = 4
        both cars reach the target at the same time-> one fleet

        When we look at cars,The car behind is faster.
        It will catch the car in front-Same fleet

        The car behind is slower.
        It will never catch the car in front-New fleet
        
        */

        int n = position.length; 
        double[][] cars = new double[n][2];

        for(int i =0 ; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        int fleets = 0;
        double previousTime = 0;

        for(int i = 0; i < n; i++){

            double currentTime = cars[i][1];

            if (currentTime > previousTime){
                fleets++;
                previousTime = currentTime;
            }
        }

        return fleets;

        





        
    }
}
