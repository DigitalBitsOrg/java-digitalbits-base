// Automatically generated on 2015-07-21T12:54:50-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct LedgerHeaderHistoryEntry
//  {
//      Hash hash;
//      LedgerHeader header;
//  
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class LedgerHeaderHistoryEntry  {
  public LedgerHeaderHistoryEntry () {}
  private Hash hash;
  public Hash gethash() {
    return this.hash;
  }
  public void sethash(Hash value) {
    this.hash = value;
  }
  private LedgerHeader header;
  public LedgerHeader getheader() {
    return this.header;
  }
  public void setheader(LedgerHeader value) {
    this.header = value;
  }
  private LedgerHeaderHistoryEntryExt ext;
  public LedgerHeaderHistoryEntryExt getext() {
    return this.ext;
  }
  public void setext(LedgerHeaderHistoryEntryExt value) {
    this.ext = value;
  }
  public static void encode(XdrDataOutputStream stream, LedgerHeaderHistoryEntry encodedLedgerHeaderHistoryEntry) throws IOException{
    Hash.encode(stream, encodedLedgerHeaderHistoryEntry.hash);
    LedgerHeader.encode(stream, encodedLedgerHeaderHistoryEntry.header);
    LedgerHeaderHistoryEntryExt.encode(stream, encodedLedgerHeaderHistoryEntry.ext);
  }
  public static LedgerHeaderHistoryEntry decode(XdrDataInputStream stream) throws IOException {
    LedgerHeaderHistoryEntry decodedLedgerHeaderHistoryEntry = new LedgerHeaderHistoryEntry();
    decodedLedgerHeaderHistoryEntry.hash = Hash.decode(stream);
    decodedLedgerHeaderHistoryEntry.header = LedgerHeader.decode(stream);
    decodedLedgerHeaderHistoryEntry.ext = LedgerHeaderHistoryEntryExt.decode(stream);
    return decodedLedgerHeaderHistoryEntry;
  }

  public static class LedgerHeaderHistoryEntryExt {
    public LedgerHeaderHistoryEntryExt () {}
    Integer v;
    public Integer getDiscriminant() {
      return this.v;
    }
    public void setDiscriminant(Integer value) {
      this.v = value;
    }
    public static void encode(XdrDataOutputStream stream, LedgerHeaderHistoryEntryExt encodedLedgerHeaderHistoryEntryExt) throws IOException {
    stream.writeInt(encodedLedgerHeaderHistoryEntryExt.getDiscriminant().intValue());
    switch (encodedLedgerHeaderHistoryEntryExt.getDiscriminant()) {
    case 0:
    break;
    }
    }
    public static LedgerHeaderHistoryEntryExt decode(XdrDataInputStream stream) throws IOException {
      LedgerHeaderHistoryEntryExt decodedLedgerHeaderHistoryEntryExt = new LedgerHeaderHistoryEntryExt();
      switch (decodedLedgerHeaderHistoryEntryExt.getDiscriminant()) {
    case 0:
    break;
    }
      return decodedLedgerHeaderHistoryEntryExt;
    }

  }
}
