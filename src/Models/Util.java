package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static final String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                    "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);


    public static boolean isValidInet4Address(String ip) {
        if (ip == null) {
            return false;
        }

        Matcher matcher = IPv4_PATTERN.matcher(ip);

        return matcher.matches();
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
