package Denemelerim;

public class Universite {

    private String unv;
    private String blm;
    private int ogrSay;
    private int notOrt;

    public Universite() {
    }

    public Universite(String unv, String blm, int ogrSay, int notOrt) {
        this.unv = unv;
        this.blm = blm;
        this.ogrSay = ogrSay;
        this.notOrt = notOrt;
    }

    public String getUnv() {
        return unv;
    }

    public void setUnv(String unv) {
        this.unv = unv;
    }

    public String getBlm() {
        return blm;
    }

    public void setBlm(String blm) {
        this.blm = blm;
    }

    public int getOgrSay() {
        return ogrSay;
    }

    public void setOgrSay(int ogrSay) {
        this.ogrSay = ogrSay;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "unv='" + unv + '\'' +
                ", blm='" + blm + '\'' +
                ", ogrSay=" + ogrSay +
                ", notOrt=" + notOrt +
                '}';
    }
}
