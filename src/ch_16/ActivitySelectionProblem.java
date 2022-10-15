package ch_16;

import java.util.HashSet;
import java.util.Set;

public class ActivitySelectionProblem {
    /*
        Problem :- We are given a list of jobs with start and finish time, where for each job, start time < finish time.
         We have to select the set of compatible activities in such a way that it contains the maximum number of activities i.e |S| is greatest.
          Two activities a(i) and a(j) are said to be compatible if start(i) > finish(j) or finish(i) < start(j) i.e the activities are disjoint.

       Solution :- The idea is to follow the greedy approach by selecting the activity which is finishing first and then following the same approach on
       the remaining compatible activities. (To check whether the next activity is compatible we will check finish(current_activity) < start(next_activity)
     */

    /*
        Recursive solution :- Here we are assuming that the activities are sorted in increasing order by their finish time i.e finish(1) < finish(2) < finish(3) < ... so on
        Input :-
        start -> int array containing the start time of activities. We will be keeping a(0) as dummy activity with start[0] = 0 and finish[0] = 0
        finish -> int array containing the finish time of the activities.
        k -> The current selected activity depending on which we will be selecting the next compatible activity
        n -> The total number of activities
        Output:-
         The largest Set<Integer> containing the index of the activities which are compatible
     */
    public static Set<Integer> activitySelectionRecursion(int[] start, int[] finish, int k, int n){
        int m = k + 1; // we have already examined upto k
        Set<Integer> ans = new HashSet<>(); // contains the answer
        while(m <= n && start[m] < finish[k]) // we will iterate until either m reaches the limit or we find the next compatible activity finishing earliest
            m++;
        if (m <= n){ // Means that our loop broke because we found the next activity
            ans.add(m); // adding the found activity in the ans
            ans.addAll(activitySelectionRecursion(start, finish, m, n)); // our final answer would be the activity found plus all other compatible activities in the remaining activities
        }
        return ans;
    }

    public static Set<Integer> activitySelectionIterative(int [] start, int[] finish, int k, int n){
        int lastFinish = 0; // our finish time of any activity will be greater than 0, so initialized lastFinished with 0
        Set<Integer> ans = new HashSet<>();
        for(int i = 0; i <= n; i++){ // we have to check for all activities for compatibility
            if(start[i] > lastFinish){ // next compatible activity will have start time which is greater than the last finished activity
                ans.add(i); // we have found the next compatible activity adding it to answer set
                lastFinish = finish[i]; // we are updating last finish for checking the compatibily of next activity
            }
        }
        return ans;
    }
}
