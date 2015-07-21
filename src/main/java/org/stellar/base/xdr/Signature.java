// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  typedef opaque Signature<64>;

//  ===========================================================================
public class Signature  {
  private byte[] Signature;
  public byte[] getSignature() {
    return this.Signature;
  }
  public void setSignature(byte[] value) {
    this.Signature = value;
  }
  public static void encode(XdrDataOutputStream stream, Signature  encodedSignature) throws IOException {
  int Signaturesize = encodedSignature.Signature.length;
  stream.writeInt(Signaturesize);
  stream.write(encodedSignature.getSignature(), 0, Signaturesize);
  }
  public static Signature decode(XdrDataInputStream stream) throws IOException {
    Signature decodedSignature = new Signature();
  int Signaturesize = stream.readInt();
  decodedSignature.Signature = new byte[Signaturesize];
  stream.read(decodedSignature.Signature, 0, Signaturesize);
    return decodedSignature;
  }
}
