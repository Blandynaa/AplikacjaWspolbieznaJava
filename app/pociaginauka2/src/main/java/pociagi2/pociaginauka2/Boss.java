package pociagi2.pociaginauka2;

public class Boss extends ProblemObject {
    public Boss(Hangar hangar,HelloController controller, char name, int lowerMSBound, int upperMSBound, int tryCount){
        super(hangar,controller, name, lowerMSBound, upperMSBound, tryCount);
    }
//
//    public Boss(Hangar hangar, char name){
//        super(hangar, name);
//    }

    @Override
    public String toString() {
        return "Boss{" + "name: '" + name + "'}";
    }
}
