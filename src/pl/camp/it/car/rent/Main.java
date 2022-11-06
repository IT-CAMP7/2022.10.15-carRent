package pl.camp.it.car.rent;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.car.rent.model.Car;
import pl.camp.it.car.rent.model.Motorcycle;
import pl.camp.it.car.rent.model.User;
import pl.camp.it.car.rent.model.builders.MotorcycleBuilder;

public class Main {
    public static void main(String[] args) {
        String a = new String("ABC");
        String b = new String("ABCd");

        System.out.println(a.equals(b));

        /*String c = null;
        c.equals("ABC");*/

        String hash = DigestUtils.md5Hex("janusz");
        System.out.println(hash);

        System.out.println(DigestUtils.md5Hex("janusz" + Authenticator.seed));

        int x = 5;
        boolean y;
        String z;
        if(x == 5) {
            y = true;
            //z = "ABC";
        } else {
            y = false;
            //z = "XYZ";
        }

        y = x==5;

        y = x==5 ? true : false;
        z = x==5 ? "ABC" : "XYZ";

        String s1 = "ABC";
        String s2 = "XYZ";

        String result = s1 + s2;
        System.out.println(result);

        StringBuilder sb = new StringBuilder();
        sb.append(s1).append(s2).append("asdf").append("sadhkjfg").append("asdf");
        result = sb.toString();
        System.out.println(result);

        Car car = new Car();
        //car.setModel("asdf").setBrand("akhsdgkj");


        Motorcycle motorcycle = new MotorcycleBuilder()
                .brand("Audi").model("A6").year(2022)
                .plate("KR99").price(234.34).cart(true).build();

        System.out.println(motorcycle.getBrand());
        System.out.println(motorcycle.getModel());
        System.out.println(motorcycle.getPlate());
        System.out.println(motorcycle.isCart());

        User user = new User();
        user.setRole(User.Role.USER);
    }
}
