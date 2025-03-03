package network01;

import java.net.InetAddress;

public class FindByIp {

    public static void main( String[] arg) {
        try {
//            InetAddress addr1 = InetAddress.getByName("127.0.0.1");
//            InetAddress addr3 = InetAddress.getLocalHost();
//
//            InetAddress addr2 = InetAddress.getByName("www.google.com");
//            System.out.println(addr2.getHostAddress());

            InetAddress addr4 = InetAddress.getByName("my.dns.name");
            System.out.println(addr4.getHostAddress());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
