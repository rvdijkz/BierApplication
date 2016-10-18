package rvdijkz.nl;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Cassandra test class
 *
 */
public class Main2 {

    public static void main(String[] args) {
        System.out.println("Hello again");

        Cluster cluster = Cluster.builder().addContactPoints("192.168.2.81").withPort(9042).build();
        Session session = cluster.connect();

        session.execute("INSERT INTO myfirstcassandradb.users (user_name, password) VALUES ('Jones2', 'Bob')");

        ResultSet results = session.execute("SELECT * FROM myfirstcassandradb.users WHERE user_name='Jones'");
        for (Row row : results) {
            System.out.format("%s %s\n", row.getString("user_name"), row.getString("password"));
        }

        System.out.println("Done");
        System.exit(0);
    }

}
