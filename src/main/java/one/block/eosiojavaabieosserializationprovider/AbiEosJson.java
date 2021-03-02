package one.block.eosiojavaabieosserializationprovider;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class holds the JSON templates for ABI conversion as immutable static Maps.  These are used
 * to serialize/deserialize specific types.
 */
public class AbiEosJson {
    public static final Map<String, String> abiEosJsonMap = initAbiEosJsonMap();

    /**
     * Initialize an immutable static map with the JSON templates for ABI and Transaction
     * serialization and deserialization.  These are used as inputs to the ABIEOS C++
     * serialization provider implementation.
     * @return - Immutable map containing the ABI and Transaction JSON serilization/deserialization templates.
     */
    private static Map<String, String> initAbiEosJsonMap() {
        Map<String, String> jsonMap = new HashMap<>();

        jsonMap.put("eosio.assert.abi.json", "{\n" +
                "   \"version\": \"eosio::abi/1.0\",\n" +
                "   \"structs\": [\n" +
                "      {\n" +
                "         \"name\": \"chain_params\",\n" +
                "         \"base\": \"\",\n" +
                "         \"fields\": [\n" +
                "            {\n" +
                "               \"name\": \"chain_id\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"chain_name\",\n" +
                "               \"type\": \"string\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"icon\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"stored_chain_params\",\n" +
                "         \"base\": \"\",\n" +
                "         \"fields\": [\n" +
                "            {\n" +
                "               \"name\": \"chain_id\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"chain_name\",\n" +
                "               \"type\": \"string\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"icon\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"hash\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"next_unique_id\",\n" +
                "               \"type\": \"uint64\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"contract_action\",\n" +
                "         \"base\": \"\",\n" +
                "         \"fields\": [\n" +
                "            {\n" +
                "               \"name\": \"contract\",\n" +
                "               \"type\": \"name\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"action\",\n" +
                "               \"type\": \"name\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"manifest\",\n" +
                "         \"base\": \"\",\n" +
                "         \"fields\": [\n" +
                "            {\n" +
                "               \"name\": \"account\",\n" +
                "               \"type\": \"name\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"domain\",\n" +
                "               \"type\": \"string\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"appmeta\",\n" +
                "               \"type\": \"string\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"whitelist\",\n" +
                "               \"type\": \"contract_action[]\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"stored_manifest\",\n" +
                "         \"base\": \"\",\n" +
                "         \"fields\": [\n" +
                "            {\n" +
                "               \"name\": \"unique_id\",\n" +
                "               \"type\": \"uint64\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"id\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"account\",\n" +
                "               \"type\": \"name\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"domain\",\n" +
                "               \"type\": \"string\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"appmeta\",\n" +
                "               \"type\": \"string\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"whitelist\",\n" +
                "               \"type\": \"contract_action[]\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"del.manifest\",\n" +
                "         \"base\": \"\",\n" +
                "         \"fields\": [\n" +
                "            {\n" +
                "               \"name\": \"id\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            }\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"require\",\n" +
                "         \"base\": \"\",\n" +
                "         \"fields\": [\n" +
                "            {\n" +
                "               \"name\": \"chain_params_hash\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"manifest_id\",\n" +
                "               \"type\": \"checksum256\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"actions\",\n" +
                "               \"type\": \"contract_action[]\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"name\": \"abi_hashes\",\n" +
                "               \"type\": \"checksum256[]\"\n" +
                "            }\n" +
                "         ]\n" +
                "      }\n" +
                "   ],\n" +
                "   \"actions\": [\n" +
                "      {\n" +
                "         \"name\": \"setchain\",\n" +
                "         \"type\": \"chain_params\",\n" +
                "         \"ricardian_contract\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"add.manifest\",\n" +
                "         \"type\": \"manifest\",\n" +
                "         \"ricardian_contract\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"del.manifest\",\n" +
                "         \"type\": \"del.manifest\",\n" +
                "         \"ricardian_contract\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"require\",\n" +
                "         \"type\": \"require\",\n" +
                "         \"ricardian_contract\": \"\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"tables\": [\n" +
                "      {\n" +
                "         \"name\": \"chain.params\",\n" +
                "         \"type\": \"stored_chain_params\",\n" +
                "         \"index_type\": \"i64\",\n" +
                "         \"key_names\": [\n" +
                "            \"key\"\n" +
                "         ],\n" +
                "         \"key_types\": [\n" +
                "            \"uint64\"\n" +
                "         ]\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"manifests\",\n" +
                "         \"type\": \"stored_manifest\",\n" +
                "         \"index_type\": \"i64\",\n" +
                "         \"key_names\": [\n" +
                "            \"key\"\n" +
                "         ],\n" +
                "         \"key_types\": [\n" +
                "            \"uint64\"\n" +
                "         ]\n" +
                "      }\n" +
                "   ],\n" +
                "   \"ricardian_clauses\": [],\n" +
                "   \"abi_extensions\": []\n" +
                "}");

        jsonMap.put("transaction.abi.json", "{\n" +
                "    \"version\": \"eosio::abi/1.0\",\n" +
                "    \"types\": [\n" +
                "        {\n" +
                "            \"new_type_name\": \"account_name\",\n" +
                "            \"type\": \"name\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"new_type_name\": \"action_name\",\n" +
                "            \"type\": \"name\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"new_type_name\": \"permission_name\",\n" +
                "            \"type\": \"name\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"structs\": [\n" +
                "        {\n" +
                "            \"name\": \"permission_level\",\n" +
                "            \"base\": \"\",\n" +
                "            \"fields\": [\n" +
                "                {\n" +
                "                    \"name\": \"actor\",\n" +
                "                    \"type\": \"account_name\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"permission\",\n" +
                "                    \"type\": \"permission_name\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"action\",\n" +
                "            \"base\": \"\",\n" +
                "            \"fields\": [\n" +
                "                {\n" +
                "                    \"name\": \"account\",\n" +
                "                    \"type\": \"account_name\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"name\",\n" +
                "                    \"type\": \"action_name\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"authorization\",\n" +
                "                    \"type\": \"permission_level[]\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"data\",\n" +
                "                    \"type\": \"bytes\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"extension\",\n" +
                "            \"base\": \"\",\n" +
                "            \"fields\": [\n" +
                "                {\n" +
                "                    \"name\": \"type\",\n" +
                "                    \"type\": \"uint16\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"data\",\n" +
                "                    \"type\": \"bytes\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"transaction_header\",\n" +
                "            \"base\": \"\",\n" +
                "            \"fields\": [\n" +
                "                {\n" +
                "                    \"name\": \"expiration\",\n" +
                "                    \"type\": \"time_point_sec\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"ref_block_num\",\n" +
                "                    \"type\": \"uint16\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"ref_block_prefix\",\n" +
                "                    \"type\": \"uint32\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"max_net_usage_words\",\n" +
                "                    \"type\": \"varuint32\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"max_cpu_usage_ms\",\n" +
                "                    \"type\": \"uint8\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"delay_sec\",\n" +
                "                    \"type\": \"varuint32\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"transaction\",\n" +
                "            \"base\": \"transaction_header\",\n" +
                "            \"fields\": [\n" +
                "                {\n" +
                "                    \"name\": \"context_free_actions\",\n" +
                "                    \"type\": \"action[]\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"actions\",\n" +
                "                    \"type\": \"action[]\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"transaction_extensions\",\n" +
                "                    \"type\": \"extension[]\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}");

        jsonMap.put("packed.transaction.abi.json", "{\n" +
                "    \"version\": \"eosio::abi/1.0\",\n" +
                "    \"structs\": [\n" +
                "        {\n" +
                "            \"name\": \"packed_transaction_v0\",\n" +
                "            \"base\": \"\",\n" +
                "            \"fields\": [\n" +
                "                {\n" +
                "                    \"name\": \"signatures\",\n" +
                "                    \"type\": \"signature[]\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"compression\",\n" +
                "                    \"type\": \"uint8\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"packed_context_free_data\",\n" +
                "                    \"type\": \"bytes\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"name\": \"packed_trx\",\n" +
                "                    \"type\": \"bytes\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}");

        jsonMap.put("ship.abi.json", "{\n" +
                "    \"version\": \"eosio::abi/1.1\",\n" +
                "    \"structs\": [\n" +
                "        {\n" +
                "            \"name\": \"get_status_request_v0\", \"fields\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"block_position\", \"fields\": [\n" +
                "                { \"name\": \"block_num\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"block_id\", \"type\": \"checksum256\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"get_status_result_v0\", \"fields\": [\n" +
                "                { \"name\": \"head\", \"type\": \"block_position\" },\n" +
                "                { \"name\": \"last_irreversible\", \"type\": \"block_position\" },\n" +
                "                { \"name\": \"trace_begin_block\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"trace_end_block\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"chain_state_begin_block\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"chain_state_end_block\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"chain_id\", \"type\": \"checksum256$\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"get_blocks_request_v0\", \"fields\": [\n" +
                "                { \"name\": \"start_block_num\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"end_block_num\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"max_messages_in_flight\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"have_positions\", \"type\": \"block_position[]\" },\n" +
                "                { \"name\": \"irreversible_only\", \"type\": \"bool\" },\n" +
                "                { \"name\": \"fetch_block\", \"type\": \"bool\" },\n" +
                "                { \"name\": \"fetch_traces\", \"type\": \"bool\" },\n" +
                "                { \"name\": \"fetch_deltas\", \"type\": \"bool\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"get_blocks_ack_request_v0\", \"fields\": [\n" +
                "                { \"name\": \"num_messages\", \"type\": \"uint32\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"get_blocks_result_v0\", \"fields\": [\n" +
                "                { \"name\": \"head\", \"type\": \"block_position\" },\n" +
                "                { \"name\": \"last_irreversible\", \"type\": \"block_position\" },\n" +
                "                { \"name\": \"this_block\", \"type\": \"block_position?\" },\n" +
                "                { \"name\": \"prev_block\", \"type\": \"block_position?\" },\n" +
                "                { \"name\": \"block\", \"type\": \"bytes?\" },\n" +
                "                { \"name\": \"traces\", \"type\": \"bytes?\" },\n" +
                "                { \"name\": \"deltas\", \"type\": \"bytes?\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"get_blocks_result_v1\", \"fields\": [\n" +
                "                { \"name\": \"head\", \"type\": \"block_position\" },\n" +
                "                { \"name\": \"last_irreversible\", \"type\": \"block_position\" },\n" +
                "                { \"name\": \"this_block\", \"type\": \"block_position?\" },\n" +
                "                { \"name\": \"prev_block\", \"type\": \"block_position?\" },\n" +
                "                { \"name\": \"block\", \"type\": \"signed_block?\" },\n" +
                "                { \"name\": \"traces\", \"type\": \"bytes\" },\n" +
                "                { \"name\": \"deltas\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"row_v0\", \"fields\": [\n" +
                "                { \"name\": \"present\", \"type\": \"bool\" },\n" +
                "                { \"name\": \"data\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"table_delta_v0\", \"fields\": [\n" +
                "                { \"name\": \"name\", \"type\": \"string\" },\n" +
                "                { \"name\": \"rows\", \"type\": \"row_v0[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"row_v1\", \"fields\": [\n" +
                "                { \"name\": \"present\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"data\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"table_delta_v1\", \"fields\": [\n" +
                "                { \"name\": \"name\", \"type\": \"string\" },\n" +
                "                { \"name\": \"rows\", \"type\": \"row_v1[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"action\", \"fields\": [\n" +
                "                { \"name\": \"account\", \"type\": \"name\" },\n" +
                "                { \"name\": \"name\", \"type\": \"name\" },\n" +
                "                { \"name\": \"authorization\", \"type\": \"permission_level[]\" },\n" +
                "                { \"name\": \"data\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"account_auth_sequence\", \"fields\": [\n" +
                "                { \"name\": \"account\", \"type\": \"name\" },\n" +
                "                { \"name\": \"sequence\", \"type\": \"uint64\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"action_receipt_v0\", \"fields\": [\n" +
                "                { \"name\": \"receiver\", \"type\": \"name\" },\n" +
                "                { \"name\": \"act_digest\", \"type\": \"checksum256\" },\n" +
                "                { \"name\": \"global_sequence\", \"type\": \"uint64\" },\n" +
                "                { \"name\": \"recv_sequence\", \"type\": \"uint64\" },\n" +
                "                { \"name\": \"auth_sequence\", \"type\": \"account_auth_sequence[]\" },\n" +
                "                { \"name\": \"code_sequence\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"abi_sequence\", \"type\": \"varuint32\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"account_delta\", \"fields\": [\n" +
                "                { \"name\": \"account\", \"type\": \"name\" },\n" +
                "                { \"name\": \"delta\", \"type\": \"int64\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"action_trace_v0\", \"fields\": [\n" +
                "                { \"name\": \"action_ordinal\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"creator_action_ordinal\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"receipt\", \"type\": \"action_receipt?\" },\n" +
                "                { \"name\": \"receiver\", \"type\": \"name\" },\n" +
                "                { \"name\": \"act\", \"type\": \"action\" },\n" +
                "                { \"name\": \"context_free\", \"type\": \"bool\" },\n" +
                "                { \"name\": \"elapsed\", \"type\": \"int64\" },\n" +
                "                { \"name\": \"console\", \"type\": \"string\" },\n" +
                "                { \"name\": \"account_ram_deltas\", \"type\": \"account_delta[]\" },\n" +
                "                { \"name\": \"except\", \"type\": \"string?\" },\n" +
                "                { \"name\": \"error_code\", \"type\": \"uint64?\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"action_trace_v1\", \"fields\": [\n" +
                "                { \"name\": \"action_ordinal\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"creator_action_ordinal\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"receipt\", \"type\": \"action_receipt?\" },\n" +
                "                { \"name\": \"receiver\", \"type\": \"name\" },\n" +
                "                { \"name\": \"act\", \"type\": \"action\" },\n" +
                "                { \"name\": \"context_free\", \"type\": \"bool\" },\n" +
                "                { \"name\": \"elapsed\", \"type\": \"int64\" },\n" +
                "                { \"name\": \"console\", \"type\": \"string\" },\n" +
                "                { \"name\": \"account_ram_deltas\", \"type\": \"account_delta[]\" },\n" +
                "                { \"name\": \"account_disk_deltas\", \"type\": \"account_delta[]\" },\n" +
                "                { \"name\": \"except\", \"type\": \"string?\" },\n" +
                "                { \"name\": \"error_code\", \"type\": \"uint64?\" },\n" +
                "                { \"name\": \"return_value\", \"type\": \"bytes\"}\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"partial_transaction_v0\", \"fields\": [\n" +
                "                { \"name\": \"expiration\", \"type\": \"time_point_sec\" },\n" +
                "                { \"name\": \"ref_block_num\", \"type\": \"uint16\" },\n" +
                "                { \"name\": \"ref_block_prefix\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"max_net_usage_words\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"max_cpu_usage_ms\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"delay_sec\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"transaction_extensions\", \"type\": \"extension[]\" },\n" +
                "                { \"name\": \"signatures\", \"type\": \"signature[]\" },\n" +
                "                { \"name\": \"context_free_data\", \"type\": \"bytes[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"partial_transaction_v1\", \"fields\": [\n" +
                "                { \"name\": \"expiration\", \"type\": \"time_point_sec\" },\n" +
                "                { \"name\": \"ref_block_num\", \"type\": \"uint16\" },\n" +
                "                { \"name\": \"ref_block_prefix\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"max_net_usage_words\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"max_cpu_usage_ms\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"delay_sec\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"transaction_extensions\", \"type\": \"extension[]\" },\n" +
                "                { \"name\": \"prunable_data\", \"type\": \"prunable_data_type?\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"transaction_trace_v0\", \"fields\": [\n" +
                "                { \"name\": \"id\", \"type\": \"checksum256\" },\n" +
                "                { \"name\": \"status\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"cpu_usage_us\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"net_usage_words\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"elapsed\", \"type\": \"int64\" },\n" +
                "                { \"name\": \"net_usage\", \"type\": \"uint64\" },\n" +
                "                { \"name\": \"scheduled\", \"type\": \"bool\" },\n" +
                "                { \"name\": \"action_traces\", \"type\": \"action_trace[]\" },\n" +
                "                { \"name\": \"account_ram_delta\", \"type\": \"account_delta?\" },\n" +
                "                { \"name\": \"except\", \"type\": \"string?\" },\n" +
                "                { \"name\": \"error_code\", \"type\": \"uint64?\" },\n" +
                "                { \"name\": \"failed_dtrx_trace\", \"type\": \"transaction_trace?\" },\n" +
                "                { \"name\": \"partial\", \"type\": \"partial_transaction?\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"packed_transaction_v0\", \"fields\": [\n" +
                "                { \"name\": \"signatures\", \"type\": \"signature[]\" },\n" +
                "                { \"name\": \"compression\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"packed_context_free_data\", \"type\": \"bytes\" },\n" +
                "                { \"name\": \"packed_trx\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"packed_transaction_v1\", \"fields\": [\n" +
                "                { \"name\": \"compression\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"prunable_data\", \"type\": \"prunable_data_type\" },\n" +
                "                { \"name\": \"packed_trx\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"transaction_receipt_header\", \"fields\": [\n" +
                "                { \"name\": \"status\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"cpu_usage_us\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"net_usage_words\", \"type\": \"varuint32\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"transaction_receipt_v0\", \"base\": \"transaction_receipt_header\", \"fields\": [\n" +
                "                { \"name\": \"trx\", \"type\": \"transaction_variant_v0\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"transaction_receipt_v1\", \"base\": \"transaction_receipt_header\", \"fields\": [\n" +
                "                { \"name\": \"trx\", \"type\": \"transaction_variant_v1\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"extension\", \"fields\": [\n" +
                "                { \"name\": \"type\", \"type\": \"uint16\" },\n" +
                "                { \"name\": \"data\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"block_header\", \"fields\": [\n" +
                "                { \"name\": \"timestamp\", \"type\": \"block_timestamp_type\" },\n" +
                "                { \"name\": \"producer\", \"type\": \"name\" },\n" +
                "                { \"name\": \"confirmed\", \"type\": \"uint16\" },\n" +
                "                { \"name\": \"previous\", \"type\": \"checksum256\" },\n" +
                "                { \"name\": \"transaction_mroot\", \"type\": \"checksum256\" },\n" +
                "                { \"name\": \"action_mroot\", \"type\": \"checksum256\" },\n" +
                "                { \"name\": \"schedule_version\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"new_producers\", \"type\": \"producer_schedule?\" },\n" +
                "                { \"name\": \"header_extensions\", \"type\": \"extension[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"signed_block_header\", \"base\": \"block_header\", \"fields\": [\n" +
                "                { \"name\": \"producer_signature\", \"type\": \"signature\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"signed_block_v0\", \"base\": \"signed_block_header\", \"fields\": [\n" +
                "                { \"name\": \"transactions\", \"type\": \"transaction_receipt_v0[]\" },\n" +
                "                { \"name\": \"block_extensions\", \"type\": \"extension[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"signed_block_v1\", \"base\": \"signed_block_header\", \"fields\": [\n" +
                "                { \"name\": \"prune_state\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"transactions\", \"type\": \"transaction_receipt_v1[]\" },\n" +
                "                { \"name\": \"block_extensions\", \"type\": \"extension[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {   \"name\": \"transaction_header\", \"fields\": [\n" +
                "                { \"name\": \"expiration\", \"type\": \"time_point_sec\" },\n" +
                "                { \"name\": \"ref_block_num\", \"type\": \"uint16\" },\n" +
                "                { \"name\": \"ref_block_prefix\", \"type\": \"uint32\" },\n" +
                "                { \"name\": \"max_net_usage_words\", \"type\": \"varuint32\" },\n" +
                "                { \"name\": \"max_cpu_usage_ms\", \"type\": \"uint8\" },\n" +
                "                { \"name\": \"delay_sec\", \"type\": \"varuint32\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {   \"name\": \"transaction\", \"base\": \"transaction_header\", \"fields\": [\n" +
                "                { \"name\": \"context_free_actions\", \"type\": \"action[]\" },\n" +
                "                { \"name\": \"actions\", \"type\": \"action[]\" },\n" +
                "                { \"name\": \"transaction_extensions\", \"type\": \"extension[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"code_id\", \"fields\": [\n" +
                "                { \"type\": \"uint8\", \"name\": \"vm_type\" },\n" +
                "                { \"type\": \"uint8\", \"name\": \"vm_version\" },\n" +
                "                { \"type\": \"checksum256\", \"name\": \"code_hash\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"account_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"name\" },\n" +
                "                { \"type\": \"block_timestamp_type\", \"name\": \"creation_date\" },\n" +
                "                { \"type\": \"bytes\", \"name\": \"abi\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"account_metadata_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"name\" },\n" +
                "                { \"type\": \"bool\", \"name\": \"privileged\" },\n" +
                "                { \"type\": \"time_point\", \"name\": \"last_code_update\" },\n" +
                "                { \"type\": \"code_id?\", \"name\": \"code\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"code_v0\", \"fields\": [\n" +
                "                { \"type\": \"uint8\", \"name\": \"vm_type\" },\n" +
                "                { \"type\": \"uint8\", \"name\": \"vm_version\" },\n" +
                "                { \"type\": \"checksum256\", \"name\": \"code_hash\" },\n" +
                "                { \"type\": \"bytes\", \"name\": \"code\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"contract_table_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"scope\" },\n" +
                "                { \"type\": \"name\", \"name\": \"table\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"contract_row_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"scope\" },\n" +
                "                { \"type\": \"name\", \"name\": \"table\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"primary_key\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" },\n" +
                "                { \"type\": \"bytes\", \"name\": \"value\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"contract_index64_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"scope\" },\n" +
                "                { \"type\": \"name\", \"name\": \"table\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"primary_key\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"secondary_key\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"contract_index128_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"scope\" },\n" +
                "                { \"type\": \"name\", \"name\": \"table\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"primary_key\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" },\n" +
                "                { \"type\": \"uint128\", \"name\": \"secondary_key\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"contract_index256_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"scope\" },\n" +
                "                { \"type\": \"name\", \"name\": \"table\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"primary_key\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" },\n" +
                "                { \"type\": \"checksum256\", \"name\": \"secondary_key\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"contract_index_double_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"scope\" },\n" +
                "                { \"type\": \"name\", \"name\": \"table\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"primary_key\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" },\n" +
                "                { \"type\": \"float64\", \"name\": \"secondary_key\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"contract_index_long_double_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"scope\" },\n" +
                "                { \"type\": \"name\", \"name\": \"table\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"primary_key\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" },\n" +
                "                { \"type\": \"float128\", \"name\": \"secondary_key\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"key_value_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"contract\" },\n" +
                "                { \"type\": \"bytes\", \"name\": \"key\" },\n" +
                "                { \"type\": \"bytes\", \"name\": \"value\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"producer_key\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"producer_name\" },\n" +
                "                { \"type\": \"public_key\", \"name\": \"block_signing_key\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"producer_schedule\", \"fields\": [\n" +
                "                { \"type\": \"uint32\", \"name\": \"version\" },\n" +
                "                { \"type\": \"producer_key[]\", \"name\": \"producers\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"block_signing_authority_v0\", \"fields\": [\n" +
                "                { \"type\": \"uint32\", \"name\": \"threshold\" },\n" +
                "                { \"type\": \"key_weight[]\", \"name\": \"keys\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"producer_authority\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"producer_name\" },\n" +
                "                { \"type\": \"block_signing_authority\", \"name\": \"authority\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"producer_authority_schedule\", \"fields\": [\n" +
                "                { \"type\": \"uint32\", \"name\": \"version\" },\n" +
                "                { \"type\": \"producer_authority[]\", \"name\": \"producers\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"chain_config_v0\", \"fields\": [\n" +
                "                { \"type\": \"uint64\", \"name\": \"max_block_net_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"target_block_net_usage_pct\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_net_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"base_per_transaction_net_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"net_usage_leeway\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"context_free_discount_net_usage_num\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"context_free_discount_net_usage_den\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_block_cpu_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"target_block_cpu_usage_pct\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_cpu_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"min_transaction_cpu_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_lifetime\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"deferred_trx_expiration_window\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_delay\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_inline_action_size\" },\n" +
                "                { \"type\": \"uint16\", \"name\": \"max_inline_action_depth\" },\n" +
                "                { \"type\": \"uint16\", \"name\": \"max_authority_depth\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"chain_config_v1\", \"fields\": [\n" +
                "                { \"type\": \"uint64\", \"name\": \"max_block_net_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"target_block_net_usage_pct\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_net_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"base_per_transaction_net_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"net_usage_leeway\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"context_free_discount_net_usage_num\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"context_free_discount_net_usage_den\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_block_cpu_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"target_block_cpu_usage_pct\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_cpu_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"min_transaction_cpu_usage\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_lifetime\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"deferred_trx_expiration_window\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_transaction_delay\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_inline_action_size\" },\n" +
                "                { \"type\": \"uint16\", \"name\": \"max_inline_action_depth\" },\n" +
                "                { \"type\": \"uint16\", \"name\": \"max_authority_depth\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_action_return_value_size\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"global_property_v0\", \"fields\": [\n" +
                "                { \"type\": \"uint32?\", \"name\": \"proposed_schedule_block_num\" },\n" +
                "                { \"type\": \"producer_schedule\", \"name\": \"proposed_schedule\" },\n" +
                "                { \"type\": \"chain_config\", \"name\": \"configuration\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"global_property_v1\", \"fields\": [\n" +
                "                { \"type\": \"uint32?\", \"name\": \"proposed_schedule_block_num\" },\n" +
                "                { \"type\": \"producer_authority_schedule\", \"name\": \"proposed_schedule\" },\n" +
                "                { \"type\": \"chain_config\", \"name\": \"configuration\" },\n" +
                "                { \"type\": \"checksum256\", \"name\": \"chain_id\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"generated_transaction_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"sender\" },\n" +
                "                { \"type\": \"uint128\", \"name\": \"sender_id\" },\n" +
                "                { \"type\": \"name\", \"name\": \"payer\" },\n" +
                "                { \"type\": \"checksum256\", \"name\": \"trx_id\" },\n" +
                "                { \"type\": \"bytes\", \"name\": \"packed_trx\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"activated_protocol_feature_v0\", \"fields\": [\n" +
                "                { \"type\": \"checksum256\", \"name\": \"feature_digest\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"activation_block_num\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"protocol_state_v0\", \"fields\": [\n" +
                "                { \"type\": \"activated_protocol_feature[]\", \"name\": \"activated_protocol_features\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"key_weight\", \"fields\": [\n" +
                "                { \"type\": \"public_key\", \"name\": \"key\" },\n" +
                "                { \"type\": \"uint16\", \"name\": \"weight\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"permission_level\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"actor\" },\n" +
                "                { \"type\": \"name\", \"name\": \"permission\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"permission_level_weight\", \"fields\": [\n" +
                "                { \"type\": \"permission_level\", \"name\": \"permission\" },\n" +
                "                { \"type\": \"uint16\", \"name\": \"weight\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"wait_weight\", \"fields\": [\n" +
                "                { \"type\": \"uint32\", \"name\": \"wait_sec\" },\n" +
                "                { \"type\": \"uint16\", \"name\": \"weight\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"authority\", \"fields\": [\n" +
                "                { \"type\": \"uint32\", \"name\": \"threshold\" },\n" +
                "                { \"type\": \"key_weight[]\", \"name\": \"keys\" },\n" +
                "                { \"type\": \"permission_level_weight[]\", \"name\": \"accounts\" },\n" +
                "                { \"type\": \"wait_weight[]\", \"name\": \"waits\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"permission_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"owner\" },\n" +
                "                { \"type\": \"name\", \"name\": \"name\" },\n" +
                "                { \"type\": \"name\", \"name\": \"parent\" },\n" +
                "                { \"type\": \"time_point\", \"name\": \"last_updated\" },\n" +
                "                { \"type\": \"authority\", \"name\": \"auth\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"permission_link_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"account\" },\n" +
                "                { \"type\": \"name\", \"name\": \"code\" },\n" +
                "                { \"type\": \"name\", \"name\": \"message_type\" },\n" +
                "                { \"type\": \"name\", \"name\": \"required_permission\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"resource_limits_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"owner\" },\n" +
                "                { \"type\": \"int64\", \"name\": \"net_weight\" },\n" +
                "                { \"type\": \"int64\", \"name\": \"cpu_weight\" },\n" +
                "                { \"type\": \"int64\", \"name\": \"ram_bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"usage_accumulator_v0\", \"fields\": [\n" +
                "                { \"type\": \"uint32\", \"name\": \"last_ordinal\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"value_ex\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"consumed\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"resource_usage_v0\", \"fields\": [\n" +
                "                { \"type\": \"name\", \"name\": \"owner\" },\n" +
                "                { \"type\": \"usage_accumulator\", \"name\": \"net_usage\" },\n" +
                "                { \"type\": \"usage_accumulator\", \"name\": \"cpu_usage\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"ram_usage\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"resource_limits_state_v0\", \"fields\": [\n" +
                "                { \"type\": \"usage_accumulator\", \"name\": \"average_block_net_usage\" },\n" +
                "                { \"type\": \"usage_accumulator\", \"name\": \"average_block_cpu_usage\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"total_net_weight\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"total_cpu_weight\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"total_ram_bytes\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"virtual_net_limit\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"virtual_cpu_limit\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"resource_limits_ratio_v0\", \"fields\": [\n" +
                "                { \"type\": \"uint64\", \"name\": \"numerator\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"denominator\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"elastic_limit_parameters_v0\", \"fields\": [\n" +
                "                { \"type\": \"uint64\", \"name\": \"target\" },\n" +
                "                { \"type\": \"uint64\", \"name\": \"max\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"periods\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"max_multiplier\" },\n" +
                "                { \"type\": \"resource_limits_ratio\", \"name\": \"contract_rate\" },\n" +
                "                { \"type\": \"resource_limits_ratio\", \"name\": \"expand_rate\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"resource_limits_config_v0\", \"fields\": [\n" +
                "                { \"type\": \"elastic_limit_parameters\", \"name\": \"cpu_limit_parameters\" },\n" +
                "                { \"type\": \"elastic_limit_parameters\", \"name\": \"net_limit_parameters\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"account_cpu_usage_average_window\" },\n" +
                "                { \"type\": \"uint32\", \"name\": \"account_net_usage_average_window\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"prunable_data_full_legacy\", \"fields\": [\n" +
                "                { \"name\": \"signatures\", \"type\": \"signature[]\" },\n" +
                "                { \"name\": \"packed_context_segments\", \"type\": \"bytes\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"prunable_data_full\", \"fields\": [\n" +
                "                { \"name\": \"signatures\", \"type\": \"signature[]\" },\n" +
                "                { \"name\": \"context_free_segments\", \"type\": \"bytes[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"prunable_data_partial\", \"fields\": [\n" +
                "                { \"name\": \"signatures\", \"type\": \"signature[]\" },\n" +
                "                { \"name\": \"context_free_segments\", \"type\": \"context_free_segment_type[]\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"prunable_data_none\", \"fields\": [\n" +
                "                { \"name\": \"prunable_digest\", \"type\": \"signature\" }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"transaction_trace_exception\", \"fields\": [\n" +
                "                { \"name\": \"error_code\", \"type\": \"int64\" },\n" +
                "                { \"name\": \"error_message\", \"type\": \"string\" }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"types\": [\n" +
                "        { \"new_type_name\": \"transaction_id\", \"type\": \"checksum256\" }\n" +
                "    ],\n" +
                "    \"variants\": [\n" +
                "        { \"name\": \"request\", \"types\": [\"get_status_request_v0\", \"get_blocks_request_v0\", \"get_blocks_ack_request_v0\"] },\n" +
                "        { \"name\": \"result\", \"types\": [\"get_status_result_v0\", \"get_blocks_result_v0\", \"get_blocks_result_v1\"] },\n" +
                "\n" +
                "        { \"name\": \"action_receipt\", \"types\": [\"action_receipt_v0\"] },\n" +
                "        { \"name\": \"action_trace\", \"types\": [\"action_trace_v0\", \"action_trace_v1\"] },\n" +
                "        { \"name\": \"partial_transaction\", \"types\": [\"partial_transaction_v0\", \"partial_transaction_v1\"] },\n" +
                "        { \"name\": \"transaction_trace\", \"types\": [\"transaction_trace_v0\"] },\n" +
                "        { \"name\": \"transaction_variant_v0\", \"types\": [\"transaction_id\", \"packed_transaction_v0\"] },\n" +
                "        { \"name\": \"transaction_variant_v1\", \"types\": [\"transaction_id\", \"packed_transaction_v1\"] },\n" +
                "        { \"name\": \"signed_block\", \"types\": [\"signed_block_v0\", \"signed_block_v1\"] },\n" +
                "        { \"name\": \"prunable_data_type\", \"types\": [\"prunable_data_full_legacy\", \"prunable_data_none\", \"prunable_data_partial\", \"prunable_data_full\"] },\n" +
                "        { \"name\": \"context_free_segment_type\", \"types\": [\"signature\", \"bytes\"] },\n" +
                "\n" +
                "        { \"name\": \"table_delta\", \"types\": [\"table_delta_v0\", \"table_delta_v1\"] },\n" +
                "        { \"name\": \"account\", \"types\": [\"account_v0\"] },\n" +
                "        { \"name\": \"account_metadata\", \"types\": [\"account_metadata_v0\"] },\n" +
                "        { \"name\": \"code\", \"types\": [\"code_v0\"] },\n" +
                "        { \"name\": \"contract_table\", \"types\": [\"contract_table_v0\"] },\n" +
                "        { \"name\": \"contract_row\", \"types\": [\"contract_row_v0\"] },\n" +
                "        { \"name\": \"contract_index64\", \"types\": [\"contract_index64_v0\"] },\n" +
                "        { \"name\": \"contract_index128\", \"types\": [\"contract_index128_v0\"] },\n" +
                "        { \"name\": \"contract_index256\", \"types\": [\"contract_index256_v0\"] },\n" +
                "        { \"name\": \"contract_index_double\", \"types\": [\"contract_index_double_v0\"] },\n" +
                "        { \"name\": \"contract_index_long_double\", \"types\": [\"contract_index_long_double_v0\"] },\n" +
                "        { \"name\": \"key_value\", \"types\": [\"key_value_v0\"] },\n" +
                "        { \"name\": \"chain_config\", \"types\": [\"chain_config_v0\", \"chain_config_v1\"] },\n" +
                "        { \"name\": \"global_property\", \"types\": [\"global_property_v0\", \"global_property_v1\"] },\n" +
                "        { \"name\": \"generated_transaction\", \"types\": [\"generated_transaction_v0\"] },\n" +
                "        { \"name\": \"activated_protocol_feature\", \"types\": [\"activated_protocol_feature_v0\"] },\n" +
                "        { \"name\": \"protocol_state\", \"types\": [\"protocol_state_v0\"] },\n" +
                "        { \"name\": \"permission\", \"types\": [\"permission_v0\"] },\n" +
                "        { \"name\": \"permission_link\", \"types\": [\"permission_link_v0\"] },\n" +
                "        { \"name\": \"resource_limits\", \"types\": [\"resource_limits_v0\"] },\n" +
                "        { \"name\": \"usage_accumulator\", \"types\": [\"usage_accumulator_v0\"] },\n" +
                "        { \"name\": \"resource_usage\", \"types\": [\"resource_usage_v0\"] },\n" +
                "        { \"name\": \"resource_limits_state\", \"types\": [\"resource_limits_state_v0\"] },\n" +
                "        { \"name\": \"resource_limits_ratio\", \"types\": [\"resource_limits_ratio_v0\"] },\n" +
                "        { \"name\": \"elastic_limit_parameters\", \"types\": [\"elastic_limit_parameters_v0\"] },\n" +
                "        { \"name\": \"resource_limits_config\", \"types\": [\"resource_limits_config_v0\"] },\n" +
                "        { \"name\": \"block_signing_authority\", \"types\": [\"block_signing_authority_v0\"] },\n" +
                "        { \"name\": \"transaction_trace_msg\", \"types\": [\"transaction_trace_exception\", \"transaction_trace\"] }\n" +
                "    ],\n" +
                "    \"tables\": [\n" +
                "        { \"name\": \"account\", \"type\": \"account\", \"key_names\": [\"name\"] },\n" +
                "        { \"name\": \"actmetadata\", \"type\": \"account_metadata\", \"key_names\": [\"name\"] },\n" +
                "        { \"name\": \"code\", \"type\": \"code\", \"key_names\": [\"vm_type\", \"vm_version\", \"code_hash\"] },\n" +
                "        { \"name\": \"contracttbl\", \"type\": \"contract_table\", \"key_names\": [\"code\", \"scope\", \"table\"] },\n" +
                "        { \"name\": \"contractrow\", \"type\": \"contract_row\", \"key_names\": [\"code\", \"scope\", \"table\", \"primary_key\"] },\n" +
                "        { \"name\": \"cntrctidx1\", \"type\": \"contract_index64\", \"key_names\": [\"code\", \"scope\", \"table\", \"primary_key\"] },\n" +
                "        { \"name\": \"cntrctidx2\", \"type\": \"contract_index128\", \"key_names\": [\"code\", \"scope\", \"table\", \"primary_key\"] },\n" +
                "        { \"name\": \"cntrctidx3\", \"type\": \"contract_index256\", \"key_names\": [\"code\", \"scope\", \"table\", \"primary_key\"] },\n" +
                "        { \"name\": \"cntrctidx4\", \"type\": \"contract_index_double\", \"key_names\": [\"code\", \"scope\", \"table\", \"primary_key\"] },\n" +
                "        { \"name\": \"cntrctidx5\", \"type\": \"contract_index_long_double\", \"key_names\": [\"code\", \"scope\", \"table\", \"primary_key\"] },\n" +
                "        { \"name\": \"keyvalue\", \"type\": \"key_value\", \"key_names\": [\"contract\", \"key\"] },\n" +
                "        { \"name\": \"global.pty\", \"type\": \"global_property\", \"key_names\": [] },\n" +
                "        { \"name\": \"generatedtrx\", \"type\": \"generated_transaction\", \"key_names\": [\"sender\", \"sender_id\"] },\n" +
                "        { \"name\": \"protocolst\", \"type\": \"protocol_state\", \"key_names\": [] },\n" +
                "        { \"name\": \"permission\", \"type\": \"permission\", \"key_names\": [\"owner\", \"name\"] },\n" +
                "        { \"name\": \"permlink\", \"type\": \"permission_link\", \"key_names\": [\"account\", \"code\", \"message_type\"] },\n" +
                "        { \"name\": \"rsclimits\", \"type\": \"resource_limits\", \"key_names\": [\"owner\"] },\n" +
                "        { \"name\": \"rscusage\", \"type\": \"resource_usage\", \"key_names\": [\"owner\"] },\n" +
                "        { \"name\": \"rsclimitsst\", \"type\": \"resource_limits_state\", \"key_names\": [] },\n" +
                "        { \"name\": \"rsclimitscfg\", \"type\": \"resource_limits_config\", \"key_names\": [] }\n" +
                "    ]\n" +
                "}");
        return Collections.unmodifiableMap(jsonMap);
    }

}
