// Copyright 2015 Stellar Development Foundation and contributors. Licensed
// under the Apache License, Version 2.0. See the COPYING file at the root
// of this distribution or at http://www.apache.org/licenses/LICENSE-2.0

%#include "xdr/Stellar-types.h"

namespace digitalbits
{

typedef opaque Value<>;

struct SCPBallot
{
    uint32 counter; // n
    Value value;    // x
};

enum SCPStatementType
{
    SCP_ST_PREPARE = 0,
    SCP_ST_CONFIRM = 1,
    SCP_ST_EXTERNALIZE = 2,
    SCP_ST_NOMINATE = 3
};

struct SCPNomination
{
    Hash quorumSetHash; // D
    Value votes<>;      // X
    Value accepted<>;   // Y
};

struct SCPStatement
{
    NodeID nodeID;    // v
    uint64 slotIndex; // i

    union switch (SCPStatementType type)
    {
    case SCP_ST_PREPARE:
        struct
        {
            Hash quorumSetHash;       // D
            SCPBallot ballot;         // b
            SCPBallot* prepared;      // p
            SCPBallot* preparedPrime; // p'
            uint32 nC;                // n_c
            uint32 nP;                // n_P
        } prepare;
    case SCP_ST_CONFIRM:
        struct
        {
            Hash quorumSetHash; // D
            uint32 nPrepared;   // n_p
            SCPBallot commit;   // c
            uint32 nP;          // n_P
        } confirm;
    case SCP_ST_EXTERNALIZE:
        struct
        {
            SCPBallot commit; // c
            uint32 nP;        // n_P
            // not from the paper, but useful to build tooling to
            // traverse the graph based off only the latest statement
            Hash commitQuorumSetHash; // D used before EXTERNALIZE
        } externalize;
    case SCP_ST_NOMINATE:
        SCPNomination nominate;
    }
    pledges;
};

struct SCPEnvelope
{
    SCPStatement statement;
    Signature signature;
};

// supports things like: A,B,C,(D,E,F),(G,H,(I,J,K,L))
// only allows 2 levels of nesting
struct SCPQuorumSet
{
    uint32 threshold;
    PublicKey validators<>;
    SCPQuorumSet innerSets<>;
};
}
