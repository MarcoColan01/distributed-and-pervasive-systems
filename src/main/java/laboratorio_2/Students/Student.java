package laboratorio_2;

import java.util.List;

public record Student(String name, String surname, int yearOfBirth, List<Address> residence, List<Exam> passedExams) {
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("STUDENTE: ")
                .append(name).append(" ")
                .append(surname)
                .append(" NATO NEL: ")
                .append(yearOfBirth)
                .append("RESIDENTE IN: ")
                .append(residence.getFirst())
                .append(" HA PASSATO GLI ESAMI: \n");
        for(Exam e: passedExams){
            sb.append(e.name() + " CON VOTO " + e.mark() + " IL GIORNO " + e.dateVerbalization() +'\n');
        }
        return sb.toString();
    }
}
