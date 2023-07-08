/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    public enum RoomStatus {
        AVAILABLE,
        OCCUPIED,
        MAINTENANCE,
        RESERVED
    }

    public class RoomReservation {
        private RoomStatus status;
        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public RoomReservation(RoomStatus status, LocalDateTime startTime, LocalDateTime endTime) {
            this.status = status;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public RoomStatus getStatus() {
            return status;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }
    }

    private List<RoomReservation> reservations;

    public Room() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(RoomStatus status, LocalDateTime startTime, LocalDateTime endTime) {
        reservations.add(new RoomReservation(status, startTime, endTime));
    }

    public RoomStatus getRoomStatus(LocalDateTime time) {
        for (RoomReservation reservation : reservations) {
            if (time.isAfter(reservation.getStartTime().minusMinutes(1)) && time.isBefore(reservation.getEndTime())) {
                return reservation.getStatus();
            }
        }
        return RoomStatus.AVAILABLE; // Trạng thái mặc định nếu không có sự kiện nào
    }
    
    private String roomNumber;
    private String type;
    private int price;

    public Room(List<RoomReservation> reservations, String roomNumber, String type, int price) {
        this.reservations = reservations;
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RoomReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<RoomReservation> reservations) {
        this.reservations = reservations;
    }

    
}
