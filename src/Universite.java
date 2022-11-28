public class Universite {

    private String univercity;
    private String bolum;
    private int ogrSayisi;
    private double notOrtalamasi;

//parametresiz constructer
    public Universite() {
    }

    //parametreli constructer
    public Universite(String univercity, String bolum, int ogrSayisi, double notOrtalamasi) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrtalamasi = notOrtalamasi;
    }

    //getter setter methodları

    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public double getNotOrtalamasi() {
        return notOrtalamasi;
    }

    public void setNotOrtalamasi(double notOrtalamasi) {
        this.notOrtalamasi = notOrtalamasi;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrtalamasi=" + notOrtalamasi +
                '}';
    }
}
