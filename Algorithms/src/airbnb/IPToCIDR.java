package airbnb;

import java.util.ArrayList;
import java.util.List;

public class IPToCIDR {
  
  public List<String> ipToCIDR(String ip, int n) {
    List<String> result = new ArrayList<>();
    if (ip == null || ip.length() == 0 || n <= 0) return result;
    
    long startIp = ipToLong(ip);
    while (n > 0) {
      int lowestBit = (int) (startIp & -startIp);
      int mask = Math.max(33 - lengthOfBit(n), 33 - lengthOfBit(lowestBit));
      result.add(longToIp(startIp) + "/" + mask);
      n = n - (1 << (32 - mask));
      startIp = startIp + (1 << (32 - mask));
    }
    
    return result;
  }
  
  public long ipToLong(String ip) {
    long result = 0;
    for (String str : ip.split("\\.")) {
      result = result * 256 + Long.valueOf(str);
    }
    return result;
  }
  
  public String longToIp(Long ip) {
    StringBuilder sb = new StringBuilder();
    sb.append(ip >>> 24);
    sb.append('.');
    sb.append((ip >>> 16) % 256);
    sb.append('.');
    sb.append((ip >>> 8) % 256);
    sb.append('.');
    sb.append(ip % 256);
    
    return sb.toString();
  }
  
  public int lengthOfBit(long n) {
    if (n == 0) return 1;
    
    int result = 0;
    while (n != 0) {
      n = n >>> 1;
      result++;
    }
    
    return result;
  }
}