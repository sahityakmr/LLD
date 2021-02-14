package chess;

public class Test {
    static class FinalClass {
        String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        final FinalClass finalClass = new FinalClass();

        finalClass.setData("Vini");
        System.out.println(finalClass.getData());

        finalClass.setData("Sahi");
        System.out.println(finalClass.getData());
    }
}
