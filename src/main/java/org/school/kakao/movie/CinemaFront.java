package org.school.kakao.movie;

import java.time.LocalTime;
import java.util.List;

public class CinemaFront extends ScreeningMovie {
    private static final int BOOK_TIME = 1_000;

    public CinemaFront(String title, Genre genre, LocalTime time, int seatAmount) {
        super(title, genre, time, seatAmount);
    }

    @Override
    public synchronized List<SeatGrade> book(List<String> order) throws IllegalArgumentException {
        try {
            String threadName = Thread.currentThread().getName();
//            OutputManager.rawPrintf("{%7s} %8s 예약 중...\n", threadName, getTitle());

            Thread.sleep(BOOK_TIME);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
        return super.book(order);
    }
}
