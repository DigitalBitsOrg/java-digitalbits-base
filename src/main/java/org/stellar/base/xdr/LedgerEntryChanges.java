// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  typedef LedgerEntryChange LedgerEntryChanges<>;

//  ===========================================================================
public class LedgerEntryChanges  {
  private LedgerEntryChange[] LedgerEntryChanges;
  public LedgerEntryChange[] getLedgerEntryChanges() {
    return this.LedgerEntryChanges;
  }
  public void setLedgerEntryChanges(LedgerEntryChange[] value) {
    this.LedgerEntryChanges = value;
  }
  public static void encode(XdrDataOutputStream stream, LedgerEntryChanges  encodedLedgerEntryChanges) throws IOException {
  int LedgerEntryChangessize = encodedLedgerEntryChanges.getLedgerEntryChanges().length;
  stream.writeInt(LedgerEntryChangessize);
  for (int i = 0; i < LedgerEntryChangessize; i++) {
    LedgerEntryChange.encode(stream, encodedLedgerEntryChanges.LedgerEntryChanges[i]);
  }
  }
  public static LedgerEntryChanges decode(XdrDataInputStream stream) throws IOException {
    LedgerEntryChanges decodedLedgerEntryChanges = new LedgerEntryChanges();
  int LedgerEntryChangessize = stream.readInt();
  decodedLedgerEntryChanges.LedgerEntryChanges = new LedgerEntryChange[LedgerEntryChangessize];
  for (int i = 0; i < LedgerEntryChangessize; i++) {
    decodedLedgerEntryChanges.LedgerEntryChanges[i] = LedgerEntryChange.decode(stream);
  }
    return decodedLedgerEntryChanges;
  }
}
