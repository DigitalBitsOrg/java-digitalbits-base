// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package io.digitalbits.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  typedef int int32;

//  ===========================================================================
public class Int32  {
  private Integer int32;
  public Integer getInt32() {
    return this.int32;
  }
  public void setInt32(Integer value) {
    this.int32 = value;
  }
  public static void encode(XdrDataOutputStream stream, Int32  encodedInt32) throws IOException {
  stream.writeInt(encodedInt32.int32);
  }
  public static Int32 decode(XdrDataInputStream stream) throws IOException {
    Int32 decodedInt32 = new Int32();
  decodedInt32.int32 = stream.readInt();
    return decodedInt32;
  }
}
