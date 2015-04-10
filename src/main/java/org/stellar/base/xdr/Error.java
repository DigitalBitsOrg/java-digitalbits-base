// Automatically generated on 2015-04-10T00:48:12-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct Error
//  {
//      int code;
//      string msg<100>;
//  };

//  ===========================================================================
public class Error  {
  public Error () {}
  private Integer code;
  public Integer getcode() {
    return this.code;
  }
  public void setcode(Integer value) {
    this.code = value;
  }
  private String msg;
  public String getmsg() {
    return this.msg;
  }
  public void setmsg(String value) {
    this.msg = value;
  }
  public static void encode(XdrDataOutputStream stream, Error encodedError) throws IOException{
    stream.writeInt(encodedError.code);
    stream.writeString(encodedError.msg);
  }
  public static Error decode(XdrDataInputStream stream) throws IOException {
    Error decodedError = new Error();
    decodedError.code = stream.readInt();
    decodedError.msg = stream.readString();
    return decodedError;
  }
}
