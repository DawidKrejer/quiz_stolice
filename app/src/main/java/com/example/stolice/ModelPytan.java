package com.example.stolice;

public class ModelPytan {
    private String pytanie, opcja1, opcja2, opcja3, opcja4;
    private int poprawnaOdpowiedz;

    public ModelPytan(String pytanie, String opcja1, String opcja2, String opcja3, String opcja4,int poprawnaOdpowiedz) {
        this.pytanie = pytanie;
        this.opcja1 = opcja1;
        this.opcja2 = opcja2;
        this.opcja3 = opcja3;
        this.opcja4 = opcja4;
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }

    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public String getOpcja1() {
        return opcja1;
    }

    public void setOpcja1(String opcja1) {
        this.opcja1 = opcja1;
    }

    public String getOpcja2() {
        return opcja2;
    }

    public void setOpcja2(String opcja2) {
        this.opcja2 = opcja2;
    }

    public String getOpcja3() {
        return opcja3;
    }

    public void setOpcja3(String opcja3) {
        this.opcja3 = opcja3;
    }

    public String getOpcja4() {
        return opcja4;
    }

    public void setOpcja4(String opcja4) {
        this.opcja4 = opcja4;
    }

    public int getPoprawnaOdpowiedz() {
        return poprawnaOdpowiedz;
    }

    public void setPoprawnaOdpowiedz(int poprawnaOdpowiedz) {
        this.poprawnaOdpowiedz = poprawnaOdpowiedz;
    }
}

