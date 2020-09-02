package userone;

import userone.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomUseListViewHandler {


    @Autowired
    private RoomUseListRepository roomUseListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingCreated_then_CREATE_1 (@Payload BookingCreated bookingCreated) {
        try {
            if (bookingCreated.isMe()) {
                // view 객체 생성
                RoomUseList roomUseList = new RoomUseList();
                // view 객체에 이벤트의 Value 를 set 함
                roomUseList.setBookingId(bookingCreated.getId());
                roomUseList.setRoomId(bookingCreated.getRoomId());
                roomUseList.setBookedUseStartDtm(bookingCreated.getUseStartDtm());
                roomUseList.setBookedUseEndDtm(bookingCreated.getUseEndDtm());
                roomUseList.setBookingUserId(bookingCreated.getBookingUsesrId());
                // view 레파지 토리에 save
                roomUseListRepository.save(roomUseList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenUseStarted_then_UPDATE_1(@Payload UseStarted useStarted) {
        try {
            if (useStarted.isMe()) {
                // view 객체 조회
                List<RoomUseList> roomUseListList = roomUseListRepository.findByBookingId(useStarted.getBookingId());
                for(RoomUseList roomUseList : roomUseListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    roomUseList.setRealUseStartDtm(useStarted.getRealUseStartDtm());
                    // view 레파지 토리에 save
                    roomUseListRepository.save(roomUseList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenUseEnded_then_UPDATE_2(@Payload UseEnded useEnded) {
        try {
            if (useEnded.isMe()) {
                // view 객체 조회
                List<RoomUseList> roomUseListList = roomUseListRepository.findByBookingId(useEnded.getBookingId());
                for(RoomUseList roomUseList : roomUseListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    roomUseList.setRealUseEndDtm(useEnded.getRealUseEndDtm());
                    // view 레파지 토리에 save
                    roomUseListRepository.save(roomUseList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}