package com.alpha.mangaapplication.utilities;

import java.util.Calendar;
import java.util.Date;

public class GetTime {
    public static Date getCurrentTime(){
        Calendar calendar = Calendar.getInstance(); // Khởi tạo một instance của Calendar lúc này Calendar vẫn chưa có thời gian chỉ mới là một instance
        calendar.setTimeInMillis(new Date().getTime()); // sử dụng phương thức setTimeInMillis để đặt thời gian cho biến calendar vừa khởi tạo
        // giá  trị là thời gian hiện tại bằng cách tạo 1 Date mới new Date().getTime()
        return new Date(calendar.getTime().getTime()); // trả về một đối tượng Date mới với thời gian là thời gian của
        // calendar.getTime(): đây là thời gian mà calendar chứa được từ dòng phía trên sau đó dùng getTime của Date để lấy ra thời gian đó
        // => trả về đối tượng Date có thời gian hiện tại
    }
    public static Date getTokenExpirationTime(int expirationTime){
        Calendar calendar = Calendar.getInstance(); // tạo một instance của calendar
        calendar.setTimeInMillis(new Date().getTime()); // lấy thời gian hiện tại
        calendar.add(Calendar.MINUTE,expirationTime); // thêm thời gian vào thời gian hiện tại với dạng minute expirationTime là gía trị được truyền vào
        return new Date(calendar.getTime().getTime()); // trả về một Date mới với thời gian hiện tại + phút ta truyền vào tham số
    }
}
