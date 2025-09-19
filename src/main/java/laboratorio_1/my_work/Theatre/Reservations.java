package laboratorio_1.src.main.java.my_work.Theatre;

public class Reservations {
    private int nSeats = 20;
    public int reserveTicket() {
        if(nSeats > 0){
            int nSeat = nSeats;
            nSeats--;
            return nSeat;
        }else return 0;
    }
}
