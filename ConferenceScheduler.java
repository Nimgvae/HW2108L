package HW_2108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ConferenceRequest {
    int startTime;
    int endTime;
    int cost;

    public ConferenceRequest(int startTime, int endTime, int cost) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.cost = cost;
    }
}

public class ConferenceScheduler {
    public static void main(String[] args) {
        List<ConferenceRequest> requests = new ArrayList<>();
        requests.add(new ConferenceRequest(9, 13, 1));
        requests.add(new ConferenceRequest(10, 14, 1));
        requests.add(new ConferenceRequest(11, 14, 1));
        requests.add(new ConferenceRequest(12, 16, 2));
        requests.add(new ConferenceRequest(13, 15, 2));

        Collections.sort(requests, new Comparator<ConferenceRequest>() {
            @Override
            public int compare(ConferenceRequest o1, ConferenceRequest o2) {
                return Integer.compare(o1.endTime, o2.endTime);
            }
        });

        int[] dp = new int[18]; // dp[i] хранит максимальную выгоду для времени i
        for (ConferenceRequest request : requests) {
            for (int time = request.startTime; time < request.endTime; time++) {
                dp[time] = Math.max(dp[time], dp[request.startTime - 1] + request.cost);
            }
        }

        int maxProfit = dp[17]; // Максимальная выгода с 9:00 до 17:00
        System.out.println("Максимальная выгода: " + maxProfit);
    }
}