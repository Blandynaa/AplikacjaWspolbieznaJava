package pociagi2.pociaginauka2;

public class Train extends ProblemObject{

    public Train(Hangar hangar,HelloController controller, char name, int lowerMSBound, int upperMSBound, int tryCount){
        super(hangar,controller, name, lowerMSBound, upperMSBound, tryCount);
    }
//
//    public Train(Hangar hangar, char name){
//        super(hangar, name);
//    }

    @Override
    public String toString() {
        return "Train{" + "name: '" + name + "'}";
    }
}
