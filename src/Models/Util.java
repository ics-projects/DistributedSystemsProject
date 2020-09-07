package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String printToyObject(Toy toy) {
        StringBuilder sb = new StringBuilder();

        if (toy.getCustomMessage() != null) {
            sb.append(toy.getCustomMessage());
        }
        if (toy.getName() != null) {
            sb.append("Toy Name : ").append(toy.getName());
        }
        if (toy.getCode() != null) {
            sb.append(" ,Toy Code : ").append(toy.getCode());
        }
        if (toy.getDescription() != null) {
            sb.append(" ,Toy Description : ").append(toy.getDescription());
        }
        if (toy.getPrice() != 0) {
            sb.append(" ,Toy Price : ").append(toy.getPrice());
        }
        if (toy.getDom() != null) {
            sb.append(" ,Toy Manufacture Date : ").append(toy.getDom());
        }
        if (toy.getToyManufacturer() != null) {
            if (toy.getToyManufacturer().getCompanyName() != null) {
                sb.append(" ,Toy Manufacture Company : ").append(toy.getToyManufacturer().getCompanyName());
            }
            if (toy.getToyManufacturer().getCountry() != null) {
                sb.append(" ,Toy Manufacture Country : ").append(toy.getToyManufacturer().getCountry());
            }

            if (toy.getToyManufacturer().getZipCode() != null) {
                sb.append(" ,Toy Manufacture Zip code : ").append(toy.getToyManufacturer().getZipCode());
            }

            if (toy.getToyManufacturer().getStreetAddress() != null) {
                sb.append(" ,Toy Manufacture Street Address : ").append(toy.getToyManufacturer().getStreetAddress());
            }
        }
        return sb.toString();
    }
}
