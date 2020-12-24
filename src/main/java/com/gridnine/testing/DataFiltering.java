package com.gridnine.testing;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;



interface Filterable{

    void excludeDepartureToCurrentMomentOfTime( List<Flight> flightList);

    void excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flightList);

    void excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flightList);


}




public class DataFiltering implements Filterable {
    private static Object LocalDateTime;

    private int nowPlusTwoHour;

    public void printList(List<Flight> flightList) {
        System.out.println("All flights:");
        flightList.forEach(System.out::println);

    }

    @Override
    public void excludeDepartureToCurrentMomentOfTime(List<Flight> flightList) {
        //filtered on condition that it exclude Departure To Current Moment Of Time

        LocalTime time = LocalTime.now();
        ;
        System.out.println("filtered on condition that it exclude Departure To Current Moment Of Time ");
        ChronoLocalDateTime<?> now = null;
        flightList.forEach(flight -> flight.getSegments().stream()
                .filter(segment -> segment.getDepartureDate().isBefore(now))
                .forEach(segment -> System.out.println(segment.toString())));
    }


    @Override
    public void excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flightList) {
       // filtered on condition that it exclude Segments With Arrival Date Earlier Than DepartureDate

        System.out.println("filtered on condition that it exclude Segments With Arrival Date Earlier Than DepartureDate ");
        flightList.forEach(flight -> flight.getSegments().stream()
                .filter(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                .forEach(segment -> System.out.println(segment.toString())));
    }


    @Override
    public void excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flightList) {

        //filtered on condition that it  exclude Total Time Spent On Earth Exceed Two Hours

        System.out.println("filtered on condition that it  exclude Total Time Spent On Earth Exceed Two Hours");
        for (Flight flight : flightList
        ) {
            for (int indexSegment = 0; indexSegment < flight.getSegments().size(); indexSegment++) {
                for (int indexNextSegment = indexSegment + 1; indexNextSegment < flight.getSegments().size(); indexNextSegment++) {
                    if (!(between(flight.getSegments().get(indexSegment).getArrivalDate(),
                            flight.getSegments().get(indexNextSegment).getDepartureDate()) > 2)) {
                        indexSegment++;

                    } else System.out.println(flight.getSegments());
                }
            }
        }
    }

    public static int between(LocalDateTime data0, LocalDateTime data1) {
        LocalDateTime = data0;
        LocalDateTime = data1;


        {

            return (int) ChronoUnit.HOURS.between(data0, data1);
        }
    }

    public int getNowPlusTwoHour() {
        return nowPlusTwoHour;
    }

    public void setNowPlusTwoHour(int nowPlusTwoHour) {
        this.nowPlusTwoHour = nowPlusTwoHour;
    }

    public int between(LocalDateTime nowPlusTwoHour) {
        return 0;
    }
}



