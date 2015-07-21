// Automatically generated on 2015-07-21T12:54:49-07:00
// DO NOT EDIT or your changes may be overwritten

package org.stellar.base.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union LedgerUpgrade switch (LedgerUpgradeType type)
//  {
//  case LEDGER_UPGRADE_VERSION:
//      uint32 newLedgerVersion; // update ledgerVersion
//  case LEDGER_UPGRADE_BASE_FEE:
//      uint32 newBaseFee; // update baseFee
//  };

//  ===========================================================================
public class LedgerUpgrade  {
  public LedgerUpgrade () {}
  LedgerUpgradeType type;
  public LedgerUpgradeType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(LedgerUpgradeType value) {
    this.type = value;
  }
  private Uint32 newLedgerVersion;
  public Uint32 getnewLedgerVersion() {
    return this.newLedgerVersion;
  }
  public void setnewLedgerVersion(Uint32 value) {
    this.newLedgerVersion = value;
  }
  private Uint32 newBaseFee;
  public Uint32 getnewBaseFee() {
    return this.newBaseFee;
  }
  public void setnewBaseFee(Uint32 value) {
    this.newBaseFee = value;
  }
  public static void encode(XdrDataOutputStream stream, LedgerUpgrade encodedLedgerUpgrade) throws IOException {
  stream.writeInt(encodedLedgerUpgrade.getDiscriminant().getValue());
  switch (encodedLedgerUpgrade.getDiscriminant()) {
  case LEDGER_UPGRADE_VERSION:
  Uint32.encode(stream, encodedLedgerUpgrade.newLedgerVersion);
  break;
  case LEDGER_UPGRADE_BASE_FEE:
  Uint32.encode(stream, encodedLedgerUpgrade.newBaseFee);
  break;
  }
  }
  public static LedgerUpgrade decode(XdrDataInputStream stream) throws IOException {
    LedgerUpgrade decodedLedgerUpgrade = new LedgerUpgrade();
    switch (decodedLedgerUpgrade.getDiscriminant()) {
  case LEDGER_UPGRADE_VERSION:
  decodedLedgerUpgrade.newLedgerVersion = Uint32.decode(stream);
  break;
  case LEDGER_UPGRADE_BASE_FEE:
  decodedLedgerUpgrade.newBaseFee = Uint32.decode(stream);
  break;
  }
    return decodedLedgerUpgrade;
  }
}
