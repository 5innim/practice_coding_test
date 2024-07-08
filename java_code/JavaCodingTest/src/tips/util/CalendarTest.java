package tips.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args){
        // Calendar 생성 방법 new 사용 안함
        Calendar cal = Calendar.getInstance();

        System.out.println("년" + cal.get(Calendar.YEAR));
        System.out.println("월" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("일" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("시간" + cal.get(Calendar.HOUR));
        System.out.println("분" + cal.get(Calendar.MINUTE));
        System.out.println("초" + cal.get(Calendar.SECOND));

        // 특정날짜 설정
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2023, 1, 2);
        System.out.println(cal2);
        System.out.println("년" + cal.get(Calendar.YEAR));
        System.out.println("월" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("일" + cal.get(Calendar.DAY_OF_MONTH));


        // java.util.Date
        /**
         * Date.getTime() 메서드는 1970년 1월 1일 00:00:00 GMT로부터 경과된 시간을 밀리초 단위로 반환합니다.
         */
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());

        // 밀리초를 초로 변환
        long seconds = d.getTime() / 1000;

        // 초를 분으로 변환
        long minutes = seconds / 60;

        // 분을 시간으로 변환
        long hours = minutes / 60;

        // 시간을 일로 변환
        long days = hours / 24;

        // 일을 년으로 변환 (대략적인 값, 윤년은 무시)
        long years = days / 365;

        System.out.println(years);
    }
}
