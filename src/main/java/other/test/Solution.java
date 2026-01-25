package java.other.test;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        StatusBooking statusBooking = check("APPROVED");


        switch(statusBooking){

            case WAITING:
                break;



        }

        System.out.println(statusBooking);

    }

    private StatusBooking check (String status) throws StatusNotFound{
        StatusBooking result = Arrays.stream(StatusBooking.values())
                .filter(statusBooking -> statusBooking.name().equals(status))
                .findFirst()
                .orElseThrow(() -> new StatusNotFound("Не найден статус " + status));
        return result;
    }

}


enum StatusBooking {
    WAITING,
    APPROVED,
    REJECTED,
    CANCELED
}

class StatusNotFound extends RuntimeException{
    public StatusNotFound(String message) {
        super(message);
    }
}
