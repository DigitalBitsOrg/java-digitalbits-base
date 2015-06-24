// Automatically generated on 2015-06-24T13:46:48-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  typedef uint64 SequenceNumber;

//  ===========================================================================
public class SequenceNumber  {
  private Uint64 SequenceNumber;
  public Uint64 getSequenceNumber() {
    return this.SequenceNumber;
  }
  public void setSequenceNumber(Uint64 value) {
    this.SequenceNumber = value;
  }
  public static void encode(XdrDataOutputStream stream, SequenceNumber  encodedSequenceNumber) throws IOException {
  Uint64.encode(stream, encodedSequenceNumber.SequenceNumber);
  }
  public static SequenceNumber decode(XdrDataInputStream stream) throws IOException {
    SequenceNumber decodedSequenceNumber = new SequenceNumber();
  decodedSequenceNumber.SequenceNumber = Uint64.decode(stream);
    return decodedSequenceNumber;
  }
}
