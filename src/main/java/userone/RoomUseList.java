package userone;

import javax.persistence.*;

@Entity
@Table(name="RoomUseList_table")
public class RoomUseList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long bookingId;
        private Long roomId;
        private String bookingUserId;
        private String bookedUseStartDtm;
        private String bookedUseEndDtm;
        private String realUseStartDtm;
        private String realUseEndDtm;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getBookingId() {
            return bookingId;
        }

        public void setBookingId(Long bookingId) {
            this.bookingId = bookingId;
        }
        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }
        public String getBookingUserId() {
            return bookingUserId;
        }

        public void setBookingUserId(String bookingUserId) {
            this.bookingUserId = bookingUserId;
        }
        public String getBookedUseStartDtm() {
            return bookedUseStartDtm;
        }

        public void setBookedUseStartDtm(String bookedUseStartDtm) {
            this.bookedUseStartDtm = bookedUseStartDtm;
        }
        public String getBookedUseEndDtm() {
            return bookedUseEndDtm;
        }

        public void setBookedUseEndDtm(String bookedUseEndDtm) {
            this.bookedUseEndDtm = bookedUseEndDtm;
        }
        public String getRealUseStartDtm() {
            return realUseStartDtm;
        }

        public void setRealUseStartDtm(String realUseStartDtm) {
            this.realUseStartDtm = realUseStartDtm;
        }
        public String getRealUseEndDtm() {
            return realUseEndDtm;
        }

        public void setRealUseEndDtm(String realUseEndDtm) {
            this.realUseEndDtm = realUseEndDtm;
        }

}
