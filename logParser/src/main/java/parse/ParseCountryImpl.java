package parse;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import constants.Constants;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import org.apache.commons.lang3.StringUtils;

public class ParseCountryImpl implements Parse {
  @Override
  public String parse(String inputLine) throws IOException, GeoIp2Exception {
    String ipAddress = StringUtils.substringBefore(inputLine, " - -");
    File database = new File(Constants.DB_PATH.getValue());
    DatabaseReader reader = new DatabaseReader.Builder(database).build();
    String country = reader.country(InetAddress.getByName(ipAddress)).getCountry().getName();
    return country;
  }
}
