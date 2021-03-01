import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import one.block.eosiojava.error.serializationProvider.*;
import one.block.eosiojava.models.AbiEosSerializationObject;
import one.block.eosiojavaabieosserializationprovider.AbiEosSerializationProviderImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class AbieosTest {

    private static AbiEosSerializationProviderImpl abieos;
    private static final String RETURN_VALUE_ABI = "{\"version\":\"eosio::abi/1.2\",\"types\":[],\"structs\":[{\"name\":\"retval.complex\",\"base\":\"\",\"fields\":[{\"name\":\"user\",\"type\":\"name\"}]},{\"name\":\"retval.simple\",\"base\":\"\",\"fields\":[{\"name\":\"user\",\"type\":\"name\"}]},{\"name\":\"retval.null\",\"base\":\"\",\"fields\":[{\"name\":\"user\",\"type\":\"name\"}]},{\"name\":\"returnValue\",\"base\":\"\",\"fields\":[{\"name\":\"id\",\"type\":\"uint32\"},{\"name\":\"name\",\"type\":\"name\"}]}],\"actions\":[{\"name\":\"retval.complex\",\"type\":\"retval.complex\",\"ricardian_contract\":\"\"},{\"name\":\"retval.simple\",\"type\":\"retval.simple\",\"ricardian_contract\":\"\"},{\"name\":\"retval.null\",\"type\":\"retval.null\",\"ricardian_contract\":\"\"}],\"tables\":[],\"ricardian_clauses\":[],\"error_messages\":[],\"abi_extensions\":[],\"variants\":[]}";
    private static final String QUERY_IT_ABI = "{\"version\":\"eosio::abi/1.1\",\"types\":[{\"new_type_name\":\"any_array\",\"type\":\"anyvar[]\"},{\"new_type_name\":\"any_object\",\"type\":\"field[]\"}],\"structs\":[{\"name\":\"null_t\",\"base\":\"\",\"fields\":[]},{\"name\":\"field\",\"base\":\"\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"anyvar\"}]},{\"name\":\"query\",\"base\":\"\",\"fields\":[{\"name\":\"method\",\"type\":\"string\"},{\"name\":\"arg\",\"type\":\"anyvar?\"},{\"name\":\"filter\",\"type\":\"query[]\"}]}],\"variants\":[{\"name\":\"anyvar\",\"types\":[\"null_t\",\"int64\",\"uint64\",\"int32\",\"uint32\",\"int16\",\"uint16\",\"int8\",\"uint8\",\"time_point\",\"checksum256\",\"float64\",\"string\",\"any_object\",\"any_array\",\"bytes\",\"symbol\",\"symbol_code\",\"asset\"]}]}";

    @BeforeClass
    public static void startSetup() {
        try {
            abieos = new AbiEosSerializationProviderImpl();
        } catch (SerializationProviderError serializationProviderError) {
            serializationProviderError.printStackTrace();
            fail();
        }
    }

    @AfterClass
    public static void endTearDown() {
        abieos.destroyContext();
        abieos = null;
    }

    @Test
    public void testHello() throws SerializationProviderError {
        String text = new AbiEosSerializationProviderImpl().stringFromAbiEos();
        System.out.println(text);
    }

    /**
     * This test was updated to swap "\n" characters out with its unicode equivalent "\u000A",
     * because ABIEOS only returns the unicode version. Java handles either format appropriately.
     */
    @Test
    public void hexToJsonAbiDef() {
        String hex = "0E656F73696F3A3A6162692F312E30010C6163636F756E745F6E616D65046E616D6505087472616E7366657200040466726F6D0C6163636F756E745F6E616D6502746F0C6163636F756E745F6E616D65087175616E74697479056173736574046D656D6F06737472696E67066372656174650002066973737565720C6163636F756E745F6E616D650E6D6178696D756D5F737570706C79056173736574056973737565000302746F0C6163636F756E745F6E616D65087175616E74697479056173736574046D656D6F06737472696E67076163636F756E7400010762616C616E63650561737365740E63757272656E63795F7374617473000306737570706C790561737365740A6D61785F737570706C79056173736574066973737565720C6163636F756E745F6E616D6503000000572D3CCDCD087472616E73666572BC072D2D2D0A7469746C653A20546F6B656E205472616E736665720A73756D6D6172793A205472616E7366657220746F6B656E732066726F6D206F6E65206163636F756E7420746F20616E6F746865722E0A69636F6E3A2068747470733A2F2F63646E2E746573746E65742E6465762E62316F70732E6E65742F746F6B656E2D7472616E736665722E706E6723636535316566396639656563613334333465383535303765306564343965373666666631323635343232626465643032353566333139366561353963386230630A2D2D2D0A0A2323205472616E73666572205465726D73202620436F6E646974696F6E730A0A492C207B7B66726F6D7D7D2C20636572746966792074686520666F6C6C6F77696E6720746F206265207472756520746F207468652062657374206F66206D79206B6E6F776C656467653A0A0A312E204920636572746966792074686174207B7B7175616E746974797D7D206973206E6F74207468652070726F6365656473206F66206672617564756C656E74206F722076696F6C656E7420616374697669746965732E0A322E2049206365727469667920746861742C20746F207468652062657374206F66206D79206B6E6F776C656467652C207B7B746F7D7D206973206E6F7420737570706F7274696E6720696E6974696174696F6E206F662076696F6C656E636520616761696E7374206F74686572732E0A332E2049206861766520646973636C6F73656420616E7920636F6E747261637475616C207465726D73202620636F6E646974696F6E732077697468207265737065637420746F207B7B7175616E746974797D7D20746F207B7B746F7D7D2E0A0A4920756E6465727374616E6420746861742066756E6473207472616E736665727320617265206E6F742072657665727369626C6520616674657220746865207B7B247472616E73616374696F6E2E64656C61795F7365637D7D207365636F6E6473206F72206F746865722064656C617920617320636F6E66696775726564206279207B7B66726F6D7D7D2773207065726D697373696F6E732E0A0A4966207468697320616374696F6E206661696C7320746F20626520697272657665727369626C7920636F6E6669726D656420616674657220726563656976696E6720676F6F6473206F722073657276696365732066726F6D20277B7B746F7D7D272C204920616772656520746F206569746865722072657475726E2074686520676F6F6473206F72207365727669636573206F7220726573656E64207B7B7175616E746974797D7D20696E20612074696D656C79206D616E6E65722E0000000000A531760569737375650000000000A86CD445066372656174650002000000384F4D113203693634010863757272656E6379010675696E743634076163636F756E740000000000904DC603693634010863757272656E6379010675696E7436340E63757272656E63795F737461747300000000";
        String jsonResult = "{\"version\":\"eosio::abi/1.0\",\"types\":[{\"new_type_name\":\"account_name\",\"type\":\"name\"}],\"structs\":[{\"name\":\"transfer\",\"base\":\"\",\"fields\":[{\"name\":\"from\",\"type\":\"account_name\"},{\"name\":\"to\",\"type\":\"account_name\"},{\"name\":\"quantity\",\"type\":\"asset\"},{\"name\":\"memo\",\"type\":\"string\"}]},{\"name\":\"create\",\"base\":\"\",\"fields\":[{\"name\":\"issuer\",\"type\":\"account_name\"},{\"name\":\"maximum_supply\",\"type\":\"asset\"}]},{\"name\":\"issue\",\"base\":\"\",\"fields\":[{\"name\":\"to\",\"type\":\"account_name\"},{\"name\":\"quantity\",\"type\":\"asset\"},{\"name\":\"memo\",\"type\":\"string\"}]},{\"name\":\"account\",\"base\":\"\",\"fields\":[{\"name\":\"balance\",\"type\":\"asset\"}]},{\"name\":\"currency_stats\",\"base\":\"\",\"fields\":[{\"name\":\"supply\",\"type\":\"asset\"},{\"name\":\"max_supply\",\"type\":\"asset\"},{\"name\":\"issuer\",\"type\":\"account_name\"}]}],\"actions\":[{\"name\":\"transfer\",\"type\":\"transfer\",\"ricardian_contract\":\"---\\u000Atitle: Token Transfer\\u000Asummary: Transfer tokens from one account to another.\\u000Aicon: https://cdn.testnet.dev.b1ops.net/token-transfer.png#ce51ef9f9eeca3434e85507e0ed49e76fff1265422bded0255f3196ea59c8b0c\\u000A---\\u000A\\u000A## Transfer Terms & Conditions\\u000A\\u000AI, {{from}}, certify the following to be true to the best of my knowledge:\\u000A\\u000A1. I certify that {{quantity}} is not the proceeds of fraudulent or violent activities.\\u000A2. I certify that, to the best of my knowledge, {{to}} is not supporting initiation of violence against others.\\u000A3. I have disclosed any contractual terms & conditions with respect to {{quantity}} to {{to}}.\\u000A\\u000AI understand that funds transfers are not reversible after the {{$transaction.delay_sec}} seconds or other delay as configured by {{from}}'s permissions.\\u000A\\u000AIf this action fails to be irreversibly confirmed after receiving goods or services from '{{to}}', I agree to either return the goods or services or resend {{quantity}} in a timely manner.\"},{\"name\":\"issue\",\"type\":\"issue\",\"ricardian_contract\":\"\"},{\"name\":\"create\",\"type\":\"create\",\"ricardian_contract\":\"\"}],\"tables\":[{\"name\":\"accounts\",\"index_type\":\"i64\",\"key_names\":[\"currency\"],\"key_types\":[\"uint64\"],\"type\":\"account\"},{\"name\":\"stat\",\"index_type\":\"i64\",\"key_names\":[\"currency\"],\"key_types\":[\"uint64\"],\"type\":\"currency_stats\"}],\"ricardian_clauses\":[],\"error_messages\":[],\"variants\":[],\"action_results\":[],\"kv_tables\":{}}";

        String json = null;

        try {
            json = abieos.deserializeAbi(hex);
        } catch (DeserializeAbiError err) {
            err.printStackTrace();
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void jsonToHexAbiDef() {
        String json = "{\"version\":\"eosio::abi/1.0\",\"types\":[{\"new_type_name\":\"account_name\",\"type\":\"name\"}],\"structs\":[{\"name\":\"transfer\",\"base\":\"\",\"fields\":[{\"name\":\"from\",\"type\":\"account_name\"},{\"name\":\"to\",\"type\":\"account_name\"},{\"name\":\"quantity\",\"type\":\"asset\"},{\"name\":\"memo\",\"type\":\"string\"}]},{\"name\":\"create\",\"base\":\"\",\"fields\":[{\"name\":\"issuer\",\"type\":\"account_name\"},{\"name\":\"maximum_supply\",\"type\":\"asset\"}]},{\"name\":\"issue\",\"base\":\"\",\"fields\":[{\"name\":\"to\",\"type\":\"account_name\"},{\"name\":\"quantity\",\"type\":\"asset\"},{\"name\":\"memo\",\"type\":\"string\"}]},{\"name\":\"account\",\"base\":\"\",\"fields\":[{\"name\":\"balance\",\"type\":\"asset\"}]},{\"name\":\"currency_stats\",\"base\":\"\",\"fields\":[{\"name\":\"supply\",\"type\":\"asset\"},{\"name\":\"max_supply\",\"type\":\"asset\"},{\"name\":\"issuer\",\"type\":\"account_name\"}]}],\"actions\":[{\"name\":\"transfer\",\"type\":\"transfer\",\"ricardian_contract\":\"---\\u000Atitle: Token Transfer\\u000Asummary: Transfer tokens from one account to another.\\u000Aicon: https://cdn.testnet.dev.b1ops.net/token-transfer.png#ce51ef9f9eeca3434e85507e0ed49e76fff1265422bded0255f3196ea59c8b0c\\u000A---\\u000A\\u000A## Transfer Terms & Conditions\\u000A\\u000AI, {{from}}, certify the following to be true to the best of my knowledge:\\u000A\\u000A1. I certify that {{quantity}} is not the proceeds of fraudulent or violent activities.\\u000A2. I certify that, to the best of my knowledge, {{to}} is not supporting initiation of violence against others.\\u000A3. I have disclosed any contractual terms & conditions with respect to {{quantity}} to {{to}}.\\u000A\\u000AI understand that funds transfers are not reversible after the {{$transaction.delay_sec}} seconds or other delay as configured by {{from}}'s permissions.\\u000A\\u000AIf this action fails to be irreversibly confirmed after receiving goods or services from '{{to}}', I agree to either return the goods or services or resend {{quantity}} in a timely manner.\"},{\"name\":\"issue\",\"type\":\"issue\",\"ricardian_contract\":\"\"},{\"name\":\"create\",\"type\":\"create\",\"ricardian_contract\":\"\"}],\"tables\":[{\"name\":\"accounts\",\"index_type\":\"i64\",\"key_names\":[\"currency\"],\"key_types\":[\"uint64\"],\"type\":\"account\"},{\"name\":\"stat\",\"index_type\":\"i64\",\"key_names\":[\"currency\"],\"key_types\":[\"uint64\"],\"type\":\"currency_stats\"}],\"ricardian_clauses\":[],\"error_messages\":[],\"abi_extensions\":[],\"variants\":[]}";
        String hexResult = "0E656F73696F3A3A6162692F312E30010C6163636F756E745F6E616D65046E616D6505087472616E7366657200040466726F6D0C6163636F756E745F6E616D6502746F0C6163636F756E745F6E616D65087175616E74697479056173736574046D656D6F06737472696E67066372656174650002066973737565720C6163636F756E745F6E616D650E6D6178696D756D5F737570706C79056173736574056973737565000302746F0C6163636F756E745F6E616D65087175616E74697479056173736574046D656D6F06737472696E67076163636F756E7400010762616C616E63650561737365740E63757272656E63795F7374617473000306737570706C790561737365740A6D61785F737570706C79056173736574066973737565720C6163636F756E745F6E616D6503000000572D3CCDCD087472616E73666572BC072D2D2D0A7469746C653A20546F6B656E205472616E736665720A73756D6D6172793A205472616E7366657220746F6B656E732066726F6D206F6E65206163636F756E7420746F20616E6F746865722E0A69636F6E3A2068747470733A2F2F63646E2E746573746E65742E6465762E62316F70732E6E65742F746F6B656E2D7472616E736665722E706E6723636535316566396639656563613334333465383535303765306564343965373666666631323635343232626465643032353566333139366561353963386230630A2D2D2D0A0A2323205472616E73666572205465726D73202620436F6E646974696F6E730A0A492C207B7B66726F6D7D7D2C20636572746966792074686520666F6C6C6F77696E6720746F206265207472756520746F207468652062657374206F66206D79206B6E6F776C656467653A0A0A312E204920636572746966792074686174207B7B7175616E746974797D7D206973206E6F74207468652070726F6365656473206F66206672617564756C656E74206F722076696F6C656E7420616374697669746965732E0A322E2049206365727469667920746861742C20746F207468652062657374206F66206D79206B6E6F776C656467652C207B7B746F7D7D206973206E6F7420737570706F7274696E6720696E6974696174696F6E206F662076696F6C656E636520616761696E7374206F74686572732E0A332E2049206861766520646973636C6F73656420616E7920636F6E747261637475616C207465726D73202620636F6E646974696F6E732077697468207265737065637420746F207B7B7175616E746974797D7D20746F207B7B746F7D7D2E0A0A4920756E6465727374616E6420746861742066756E6473207472616E736665727320617265206E6F742072657665727369626C6520616674657220746865207B7B247472616E73616374696F6E2E64656C61795F7365637D7D207365636F6E6473206F72206F746865722064656C617920617320636F6E66696775726564206279207B7B66726F6D7D7D2773207065726D697373696F6E732E0A0A4966207468697320616374696F6E206661696C7320746F20626520697272657665727369626C7920636F6E6669726D656420616674657220726563656976696E6720676F6F6473206F722073657276696365732066726F6D20277B7B746F7D7D272C204920616772656520746F206569746865722072657475726E2074686520676F6F6473206F72207365727669636573206F7220726573656E64207B7B7175616E746974797D7D20696E20612074696D656C79206D616E6E65722E0000000000A531760569737375650000000000A86CD445066372656174650002000000384F4D113203693634010863757272656E6379010675696E743634076163636F756E740000000000904DC603693634010863757272656E6379010675696E7436340E63757272656E63795F7374617473000000000000";

        String hex = null;

        try {
            hex = abieos.serializeAbi(json);
        } catch (SerializeAbiError err) {
            err.printStackTrace();
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void hexToJsonAbiTransaction() {
        String hex = "8468635b7f379feeb95500000000010000000000ea305500409e9a2264b89a010000000000ea305500000000a8ed3232660000000000ea305500a6823403ea30550100000001000240cc0bf90a5656c8bb81f0eb86f49f89613c5cd988c018715d4646c6bd0ad3d8010000000100000001000240cc0bf90a5656c8bb81f0eb86f49f89613c5cd988c018715d4646c6bd0ad3d80100000000";
        String jsonResult = "{\"expiration\":\"2018-08-02T20:24:36.000\",\"ref_block_num\":14207,\"ref_block_prefix\":1438248607,\"max_net_usage_words\":0,\"max_cpu_usage_ms\":0,\"delay_sec\":0,\"context_free_actions\":[],\"actions\":[{\"account\":\"eosio\",\"name\":\"newaccount\",\"authorization\":[{\"actor\":\"eosio\",\"permission\":\"active\"}],\"data\":\"0000000000EA305500A6823403EA30550100000001000240CC0BF90A5656C8BB81F0EB86F49F89613C5CD988C018715D4646C6BD0AD3D8010000000100000001000240CC0BF90A5656C8BB81F0EB86F49F89613C5CD988C018715D4646C6BD0AD3D801000000\"}],\"transaction_extensions\":[]}";

        String json = null;

        try {
            json = abieos.deserializeTransaction(hex);
        } catch (DeserializeTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void abiSerializeActionResults() {
        String json = "{\"version\":\"eosio::abi/1.2\",\"types\":[],\"structs\":[{\"name\":\"actionresret\",\"base\":\"\",\"fields\":[]}],\"actions\":[{\"name\":\"actionresret\",\"type\":\"actionresret\",\"ricardian_contract\":\"\"}],\"tables\":[],\"ricardian_clauses\":[],\"error_messages\":[],\"action_results\":[{\"name\":\"actionresret\",\"result_type\":\"int32\"}]}";
        String hex = "0E656F73696F3A3A6162692F312E3200010C616374696F6E72657372657400000190D5C5EA4EEA32320C616374696F6E7265737265740000000000000190D5C5EA4EEA323205696E74333200";

        String hexReturn = null;

        try {
            hexReturn = abieos.serializeAbi(json);
        } catch (SerializeAbiError err) {
            err.printStackTrace();
        }

        assertNotNull(hexReturn);
        assertEquals(hexReturn, hex);
    }

    @Test
    public void abiDeserializeActionResults() {
        String hex = "0E656F73696F3A3A6162692F312E3200010C616374696F6E72657372657400000190D5C5EA4EEA32320C616374696F6E7265737265740000000000000190D5C5EA4EEA323205696E74333200";
        String json = "{\"version\":\"eosio::abi/1.2\",\"types\":[],\"structs\":[{\"name\":\"actionresret\",\"base\":\"\",\"fields\":[]}],\"actions\":[{\"name\":\"actionresret\",\"type\":\"actionresret\",\"ricardian_contract\":\"\"}],\"tables\":[],\"ricardian_clauses\":[],\"error_messages\":[],\"action_results\":[{\"name\":\"actionresret\",\"result_type\":\"int32\"}]}";

        String jsonReturn = null;

        try {
            jsonReturn = abieos.deserializeAbi(hex);
        } catch (DeserializeAbiError err) {
            err.printStackTrace();
        }

        assertNotNull(jsonReturn);
        assertTrue(isJsonSubset(json, jsonReturn));
    }

    @Test
    public void hexToJsonAbiTokenTransfer() {
        String hex = "00AEAA4AC15CFD4500000060D234CD3DA06806000000000004454F53000000001A746865206772617373686F70706572206C696573206865617679";
        String jsonResult = "{\"from\":\"cryptkeeper\",\"to\":\"brandon\",\"quantity\":\"42.0000 EOS\",\"memo\":\"the grasshopper lies heavy\"}";
        String abi = "{\"version\":\"eosio::abi/1.0\",\"types\":[{\"new_type_name\":\"account_name\",\"type\":\"name\"}],\"structs\":[{\"name\":\"transfer\",\"base\":\"\",\"fields\":[{\"name\":\"from\",\"type\":\"account_name\"},{\"name\":\"to\",\"type\":\"account_name\"},{\"name\":\"quantity\",\"type\":\"asset\"},{\"name\":\"memo\",\"type\":\"string\"}]},{\"name\":\"create\",\"base\":\"\",\"fields\":[{\"name\":\"issuer\",\"type\":\"account_name\"},{\"name\":\"maximum_supply\",\"type\":\"asset\"}]},{\"name\":\"issue\",\"base\":\"\",\"fields\":[{\"name\":\"to\",\"type\":\"account_name\"},{\"name\":\"quantity\",\"type\":\"asset\"},{\"name\":\"memo\",\"type\":\"string\"}]},{\"name\":\"account\",\"base\":\"\",\"fields\":[{\"name\":\"balance\",\"type\":\"asset\"}]},{\"name\":\"currency_stats\",\"base\":\"\",\"fields\":[{\"name\":\"supply\",\"type\":\"asset\"},{\"name\":\"max_supply\",\"type\":\"asset\"},{\"name\":\"issuer\",\"type\":\"account_name\"}]}],\"actions\":[{\"name\":\"transfer\",\"type\":\"transfer\",\"ricardian_contract\":\"---\\ntitle: Token Transfer\\nsummary: Transfer tokens from one account to another.\\nicon: https://cdn.testnet.dev.b1ops.net/token-transfer.png#ce51ef9f9eeca3434e85507e0ed49e76fff1265422bded0255f3196ea59c8b0c\\n---\\n\\n## Transfer Terms & Conditions\\n\\nI, {{from}}, certify the following to be true to the best of my knowledge:\\n\\n1. I certify that {{quantity}} is not the proceeds of fraudulent or violent activities.\\n2. I certify that, to the best of my knowledge, {{to}} is not supporting initiation of violence against others.\\n3. I have disclosed any contractual terms & conditions with respect to {{quantity}} to {{to}}.\\n\\nI understand that funds transfers are not reversible after the {{$transaction.delay_sec}} seconds or other delay as configured by {{from}}'s permissions.\\n\\nIf this action fails to be irreversibly confirmed after receiving goods or services from '{{to}}', I agree to either return the goods or services or resend {{quantity}} in a timely manner.\"},{\"name\":\"issue\",\"type\":\"issue\",\"ricardian_contract\":\"\"},{\"name\":\"create\",\"type\":\"create\",\"ricardian_contract\":\"\"}],\"tables\":[{\"name\":\"accounts\",\"index_type\":\"i64\",\"key_names\":[\"currency\"],\"key_types\":[\"uint64\"],\"type\":\"account\"},{\"name\":\"stat\",\"index_type\":\"i64\",\"key_names\":[\"currency\"],\"key_types\":[\"uint64\"],\"type\":\"currency_stats\"}],\"ricardian_clauses\":[],\"error_messages\":[],\"abi_extensions\":[],\"variants\":[]}";

        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("eosio.token", "transfer", null, abi);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void jsonToHexSimpleReturnValue() {
        String json = "10";
        String returnValueType = "uint32";
        String hexResult = "0A000000";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "retval.simple", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void jsonToHexComplexReturnValue() {
        String json = "{\"id\":1234,\"name\":\"test\"}";
        String returnValueType = "returnValue";
        String hexResult = "D2040000000000000090B1CA";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "retval.complex", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void jsonToHexNullReturnValueShouldDefaultToActionData() {
        String json = "{\"user\":\"test\"}";
        String returnValueType = null;
        String hexResult = "000000000090B1CA";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "retval.null", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void jsonToHexReturnValueShouldBeAbleToSpecifyEmptyContractAndActionName() {
        String json = "10";
        String returnValueType = "uint32";
        String hexResult = "0A000000";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("", "", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void jsonToHexReturnValueShouldBeAbleToSpecifyNullContractAndActionName() {
        String json = "10";
        String returnValueType = "uint32";
        String hexResult = "0A000000";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, RETURN_VALUE_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void jsonToHexNullReturnValueShouldThrowWhenDefaultsToInvalidAction() {
        String json = "{\"user\":\"test\"}";
        String returnValueType = null;
        String hex = null;
        Boolean errorThrown = false;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "invalid", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            errorThrown = true;
            assertEquals("one.block.eosiojava.error.serializationProvider.SerializeError: Unable to find type for action invalid. contract \"contract\" does not have action \"invalid\"", err.getMessage());
        }

        assertNull(hex);
        assertTrue(errorThrown);
    }

    @Test
    public void hexToJsonSimpleReturnValue() {
        String hex = "0A000000";
        String returnValueType = "uint32";
        String jsonResult = "10";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "retval.simple", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void hexToJsonComplexReturnValue() {
        String hex = "D2040000000000000090B1CA";
        String returnValueType = "returnValue";
        String jsonResult = "{\"id\":1234,\"name\":\"test\"}";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "retval.complex", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void hexToJsonNullReturnValueShouldDefaultToActionData() {
        String hex = "000000000090B1CA";
        String returnValueType = null;
        String jsonResult = "{\"user\":\"test\"}";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "retval.null", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void hexToJsonReturnValueShouldBeAbleToSpecifyEmptyContractAndActionName() {
        String hex = "0A000000";
        String returnValueType = "uint32";
        String jsonResult = "10";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("", "", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void hexToJsonReturnValueShouldBeAbleToSpecifyNullContractAndActionName() {
        String hex = "0A000000";
        String returnValueType = "uint32";
        String jsonResult = "10";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, RETURN_VALUE_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void hexToJsonNullReturnValueShouldThrowWhenDefaultsToInvalidAction() {
        String hex = "000000000090B1CA";
        String returnValueType = null;
        String json = null;
        Boolean errorThrown = false;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject("contract", "invalid", returnValueType, RETURN_VALUE_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            errorThrown = true;
            assertEquals("one.block.eosiojava.error.serializationProvider.DeserializeError: Unable to find type for action invalid. contract \"contract\" does not have action \"invalid\"", err.getMessage());
        }

        assertNull(json);
        assertTrue(errorThrown);
    }

    @Test
    public void jsonToHexTransaction2() {
        String json = "{\n" +
                "\"expiration\" : \"2019-02-12T20:35:38.000\",\n" +
                "\"ref_block_num\" : 60851,\n" +
                "\"ref_block_prefix\" : 1743894440,\n" +
                "\"max_net_usage_words\" : 0,\n" +
                "\"max_cpu_usage_ms\" : 0,\n" +
                "\"delay_sec\" : 0,\n" +
                "\"context_free_actions\" : [],\n" +
                "\"actions\" : [\n" +
                "{\n" +
                "\"account\" : \"eosio.assert\",\n" +
                "\"name\" : \"require\",\n" +
                "\"authorization\" : [],\n" +
                "\"data\" : \"CBDD956F52ACD910C3C958136D72F8560D1846BC7CF3157F5FBFB72D3001DE4597F4A1FDBECDA6D59C96A43009FC5E5D7B8F639B1269C77CEC718460DCC19CB30100A6823403EA3055000000572D3CCDCD0143864D5AF0FE294D44D19C612036CBE8C098414C4A12A5A7BB0BFE7DB1556248\"\n" +
                "},\n" +
                "{\n" +
                "\"account\" : \"eosio.token\",\n" +
                "\"name\" : \"transfer\",\n" +
                "\"authorization\" : [\n" +
                "{\n" +
                "\"actor\" : \"cryptkeeper\",\n" +
                "\"permission\" : \"active\"\n" +
                "}\n" +
                "],\n" +
                "\"data\" : \"00AEAA4AC15CFD4500000060D234CD3DA06806000000000004454F53000000001A746865206772617373686F70706572206C696573206865617679\"\n" +
                "}\n" +
                "]\n" +
                ",\n" +
                "\"transaction_extensions\" : []\n" +
                "}";

        String hexResult = "1A2E635CB3EDA8B7F167000000000290AFC2D800EA3055000000405DA7ADBA0072CBDD956F52ACD910C3C958136D72F8560D1846BC7CF3157F5FBFB72D3001DE4597F4A1FDBECDA6D59C96A43009FC5E5D7B8F639B1269C77CEC718460DCC19CB30100A6823403EA3055000000572D3CCDCD0143864D5AF0FE294D44D19C612036CBE8C098414C4A12A5A7BB0BFE7DB155624800A6823403EA3055000000572D3CCDCD0100AEAA4AC15CFD4500000000A8ED32323B00AEAA4AC15CFD4500000060D234CD3DA06806000000000004454F53000000001A746865206772617373686F70706572206C69657320686561767900";

        String hex = null;

        try {
            hex = abieos.serializeTransaction(json);
        } catch (SerializeTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void testContextError() {
        try {
            abieos.destroyContext();
            String err = abieos.error();
            fail("Should have thrown an error because the context was null.");
        } catch (SerializationProviderError ace) {

        }
    }

    @Test
    public void testQueryItAnyVarSerialization() {
        String json = "[\"string\",\"test\"]";
        String returnValueType = "anyvar";
        String hexResult = "0C0474657374";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, QUERY_IT_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void testQueryItAnyArraySerialization() {
        String json = "[[\"string\",\"test\"]]";
        String returnValueType = "any_array";
        String hexResult = "010C0474657374";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, QUERY_IT_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void testQueryItAnyObjectSerialization() {
        String json = "[{\"name\": \"something\", \"value\": [\"string\", \"test\"]}]";
        String returnValueType = "any_object";
        String hexResult = "0109736F6D657468696E670C0474657374";
        String hex = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, QUERY_IT_ABI);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hex = serializationObject.getHex();
        } catch (SerializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void testQueryItAnyVarDeserialization() {
        String hex = "0C0474657374";
        String returnValueType = "anyvar";
        String jsonResult = "[\"string\",\"test\"]";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, QUERY_IT_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void testQueryItAnyArrayDeserialization() {
        String hex = "010C0474657374";
        String returnValueType = "any_array";
        String jsonResult = "[[\"string\",\"test\"]]";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, QUERY_IT_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void testQueryItAnyObjectDeserialization() {
        String hex = "0109736F6D657468696E670C0474657374";
        String returnValueType = "any_object";
        String jsonResult = "[{\"name\":\"something\",\"value\":[\"string\",\"test\"]}]";
        String json = null;

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, QUERY_IT_ABI);
            serializationObject.setHex(hex);
            abieos.deserialize(serializationObject);
            json = serializationObject.getJson();
        } catch (DeserializeError err) {
            err.printStackTrace();
            fail("Should not have thrown an error.");
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    /**
     * Type: any_object
     * Variant: null_t
     */
    @Test
    public void testQueryItAnyObjectTypeNull_TVariant() {
        String returnValueType = "any_object";
        String hex = "00";
        String json = "[]";
        String jsonResult = null;

        try {
            AbiEosSerializationObject deserializationObject = new AbiEosSerializationObject("queryit", "queryit", returnValueType, QUERY_IT_ABI);
            deserializationObject.setHex(hex);
            abieos.deserialize(deserializationObject);
            jsonResult = deserializationObject.getJson();
        } catch (DeserializeError deserializeError) {
            deserializeError.printStackTrace();
        }

        assertNotNull(jsonResult);
        assertEquals(json, jsonResult);
    }

    /**
     * Type: any_array
     * Variant: null_t
     */
    @Test
    public void testQueryItAnyArrayTypeNull_TVariant() {
        String returnValueType = "any_array";
        String hex = "00";
        String json = "[]";
        String jsonResult = null;

        try {
            AbiEosSerializationObject deserializationObject = new AbiEosSerializationObject("queryit", "queryit", returnValueType, QUERY_IT_ABI);
            deserializationObject.setHex(hex);
            abieos.deserialize(deserializationObject);
            jsonResult = deserializationObject.getJson();
        } catch (DeserializeError deserializeError) {
            deserializeError.printStackTrace();
        }

        assertNotNull(jsonResult);
        assertEquals(json, jsonResult);
    }

    @Test
    public void testQueryItAbiSerializeAndDeserializeMatch() {
        String queryItAbi = "{\"version\":\"eosio::abi/1.1\",\"types\":[{\"new_type_name\":\"any_array\",\"type\":\"anyvar[]\"},{\"new_type_name\":\"any_object\",\"type\":\"field[]\"}],\"structs\":[{\"name\":\"null_t\",\"base\":\"\",\"fields\":[]},{\"name\":\"field\",\"base\":\"\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"anyvar\"}]},{\"name\":\"query\",\"base\":\"\",\"fields\":[{\"name\":\"method\",\"type\":\"string\"},{\"name\":\"arg\",\"type\":\"anyvar?\"},{\"name\":\"filter\",\"type\":\"query[]\"}]}],\"variants\":[{\"name\":\"anyvar\",\"types\":[\"null_t\",\"int64\",\"uint64\",\"int32\",\"uint32\",\"int16\",\"uint16\",\"int8\",\"uint8\",\"time_point\",\"checksum256\",\"float64\",\"string\",\"any_object\",\"any_array\",\"bytes\",\"symbol\",\"symbol_code\",\"asset\"]}]}";
        String returnValueType = "anyvar";
        String hex = "0D070571756F74650C103533383035393639302E32312055534404626173650C1238393335322E3534303030303030204254430B62616E636F7250726963650C0B363032312E3736205553440E6C617374547261646550726963650C0B363031302E383720555344116C61737454726164655175616E746974790C103136312E3839303835393437204254430461736B730D010565646765730E0004626964730D010565646765730E040D01046E6F64650D08076F726465724964020400000000000000056F776E65720C056D616B65720668616E646C650220766BF085AA05000570726963650C0B353030302E30302055534404636F73740C08302E3030205553440972656D61696E696E670C0E312E3030303030303030204254430473697A650C0E312E30303030303030302042544307637265617465640980791FA58CAA05000D01046E6F64650D08076F726465724964020900000000000000056F776E65720C0B6D61786E616D73746F726D0668616E646C6502A0DC160486AA05000570726963650C0B353030302E30302055534404636F73740C08302E3030205553440972656D61696E696E670C0F31302E3030303030303030204254430473697A650C0F31302E303030303030303020425443076372656174656409C09DBBB88CAA05000D01046E6F64650D08076F726465724964020A00000000000000056F776E65720C0B6D61786E616D73746F726D0668616E646C65026057090986AA05000570726963650C0B353030302E30302055534404636F73740C08302E3030205553440972656D61696E696E670C0F31302E3030303030303030204254430473697A650C0F31302E303030303030303020425443076372656174656409A0B9B5BD8CAA05000D01046E6F64650D08076F726465724964020700000000000000056F776E65720C056D616B65720668616E646C6502A06B50FA85AA05000570726963650C0B353139392E35302055534404636F73740C08302E3030205553440972656D61696E696E670C0E312E3030303030303030204254430473697A650C0E312E303030303030303020425443076372656174656409C02CF5AE8CAA0500";
        String json = "[\"any_object\",[{\"name\":\"quote\",\"value\":[\"string\",\"538059690.21 USD\"]},{\"name\":\"base\",\"value\":[\"string\",\"89352.54000000 BTC\"]},{\"name\":\"bancorPrice\",\"value\":[\"string\",\"6021.76 USD\"]},{\"name\":\"lastTradePrice\",\"value\":[\"string\",\"6010.87 USD\"]},{\"name\":\"lastTradeQuantity\",\"value\":[\"string\",\"161.89085947 BTC\"]},{\"name\":\"asks\",\"value\":[\"any_object\",[{\"name\":\"edges\",\"value\":[\"any_array\",[]]}]]},{\"name\":\"bids\",\"value\":[\"any_object\",[{\"name\":\"edges\",\"value\":[\"any_array\",[[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"4\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maker\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867124500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5000.00 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:38:46.000\"]}]]}]],[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"9\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maxnamstorm\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867454500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5000.00 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:44:15.000\"]}]]}]],[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"10\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maxnamstorm\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867537500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5000.00 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:45:38.500\"]}]]}]],[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"7\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maker\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867290500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5199.50 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:41:31.000\"]}]]}]]]]}]]}]]";

        String hexResult = null;
        String jsonResult = null;

        try {
            AbiEosSerializationObject deserializationObject = new AbiEosSerializationObject(null, null, returnValueType, queryItAbi);
            deserializationObject.setHex(hex);
            abieos.deserialize(deserializationObject);
            jsonResult = deserializationObject.getJson();
        } catch (DeserializeError deserializeError) {
            deserializeError.printStackTrace();
        }

        try {
            AbiEosSerializationObject serializationObject = new AbiEosSerializationObject(null, null, returnValueType, queryItAbi);
            serializationObject.setJson(json);
            abieos.serialize(serializationObject);
            hexResult = serializationObject.getHex();
        } catch (SerializeError serializeError) {
            serializeError.printStackTrace();
        }

        assertNotNull(jsonResult);
        assertEquals(json, jsonResult);

        assertNotNull(hexResult);
        assertEquals(hex, hexResult);
    }

    @Test
    public void testQueryItAbiDeserialize() {
        String queryItAbi = "{\"version\":\"eosio::abi/1.1\",\"types\":[{\"new_type_name\":\"any_array\",\"type\":\"anyvar[]\"},{\"new_type_name\":\"any_object\",\"type\":\"field[]\"}],\"structs\":[{\"name\":\"null_t\",\"base\":\"\",\"fields\":[]},{\"name\":\"field\",\"base\":\"\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"value\",\"type\":\"anyvar\"}]},{\"name\":\"query\",\"base\":\"\",\"fields\":[{\"name\":\"method\",\"type\":\"string\"},{\"name\":\"arg\",\"type\":\"anyvar?\"},{\"name\":\"filter\",\"type\":\"query[]\"}]}],\"variants\":[{\"name\":\"anyvar\",\"types\":[\"null_t\",\"int64\",\"uint64\",\"int32\",\"uint32\",\"int16\",\"uint16\",\"int8\",\"uint8\",\"time_point\",\"checksum256\",\"float64\",\"string\",\"any_object\",\"any_array\",\"bytes\",\"symbol\",\"symbol_code\",\"asset\"]}]}";
        String returnValueType = "anyvar";
        String hex = "0D070571756F74650C103533383035393639302E32312055534404626173650C1238393335322E3534303030303030204254430B62616E636F7250726963650C0B363032312E3736205553440E6C617374547261646550726963650C0B363031302E383720555344116C61737454726164655175616E746974790C103136312E3839303835393437204254430461736B730D010565646765730E0004626964730D010565646765730E040D01046E6F64650D08076F726465724964020400000000000000056F776E65720C056D616B65720668616E646C650220766BF085AA05000570726963650C0B353030302E30302055534404636F73740C08302E3030205553440972656D61696E696E670C0E312E3030303030303030204254430473697A650C0E312E30303030303030302042544307637265617465640980791FA58CAA05000D01046E6F64650D08076F726465724964020900000000000000056F776E65720C0B6D61786E616D73746F726D0668616E646C6502A0DC160486AA05000570726963650C0B353030302E30302055534404636F73740C08302E3030205553440972656D61696E696E670C0F31302E3030303030303030204254430473697A650C0F31302E303030303030303020425443076372656174656409C09DBBB88CAA05000D01046E6F64650D08076F726465724964020A00000000000000056F776E65720C0B6D61786E616D73746F726D0668616E646C65026057090986AA05000570726963650C0B353030302E30302055534404636F73740C08302E3030205553440972656D61696E696E670C0F31302E3030303030303030204254430473697A650C0F31302E303030303030303020425443076372656174656409A0B9B5BD8CAA05000D01046E6F64650D08076F726465724964020700000000000000056F776E65720C056D616B65720668616E646C6502A06B50FA85AA05000570726963650C0B353139392E35302055534404636F73740C08302E3030205553440972656D61696E696E670C0E312E3030303030303030204254430473697A650C0E312E303030303030303020425443076372656174656409C02CF5AE8CAA0500";
        String json = "[\"any_object\",[{\"name\":\"quote\",\"value\":[\"string\",\"538059690.21 USD\"]},{\"name\":\"base\",\"value\":[\"string\",\"89352.54000000 BTC\"]},{\"name\":\"bancorPrice\",\"value\":[\"string\",\"6021.76 USD\"]},{\"name\":\"lastTradePrice\",\"value\":[\"string\",\"6010.87 USD\"]},{\"name\":\"lastTradeQuantity\",\"value\":[\"string\",\"161.89085947 BTC\"]},{\"name\":\"asks\",\"value\":[\"any_object\",[{\"name\":\"edges\",\"value\":[\"any_array\",[]]}]]},{\"name\":\"bids\",\"value\":[\"any_object\",[{\"name\":\"edges\",\"value\":[\"any_array\",[[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"4\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maker\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867124500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5000.00 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:38:46.000\"]}]]}]],[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"9\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maxnamstorm\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867454500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5000.00 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:44:15.000\"]}]]}]],[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"10\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maxnamstorm\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867537500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5000.00 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"10.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:45:38.500\"]}]]}]],[\"any_object\",[{\"name\":\"node\",\"value\":[\"any_object\",[{\"name\":\"orderId\",\"value\":[\"uint64\",\"7\"]},{\"name\":\"owner\",\"value\":[\"string\",\"maker\"]},{\"name\":\"handle\",\"value\":[\"uint64\",\"1594867290500000\"]},{\"name\":\"price\",\"value\":[\"string\",\"5199.50 USD\"]},{\"name\":\"cost\",\"value\":[\"string\",\"0.00 USD\"]},{\"name\":\"remaining\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"size\",\"value\":[\"string\",\"1.00000000 BTC\"]},{\"name\":\"created\",\"value\":[\"time_point\",\"2020-07-16T10:41:31.000\"]}]]}]]]]}]]}]]";
        String jsonResult = null;

        try {
            AbiEosSerializationObject deserializationObject = new AbiEosSerializationObject(null, null, returnValueType, queryItAbi);
            deserializationObject.setHex(hex);
            abieos.deserialize(deserializationObject);
            jsonResult = deserializationObject.getJson();
        } catch (DeserializeError deserializeError) {
            deserializeError.printStackTrace();
        }

        assertNotNull(jsonResult);
        assertEquals(json, jsonResult);
    }

    @Test
    public void jsonToHexPackedTransaction() {
        String json = "{\"signatures\":[\"SIG_K1_K5PGhrkUBkThs8zdTD9mGUJZvxL4eU46UjfYJSEdZ9PXS2Cgv5jAk57yTx4xnrdSocQm6DDvTaEJZi5WLBsoZC4XYNS8b3\"],\"compression\":0,\"packed_context_free_data\":\"\",\"packed_trx\":\"D3029649D2042E160000000000000100A6823403EA3055000000572D3CCDCD01608C31C6187315D600000000A8ED323221608C31C6187315D6708C31C6187315D6010000000000000004535953000000000000\"}";
        String hexResult = "01001F4D6C791D32E38CA1A0A5F3139B8D1D521B641FE2EE675311FCA4C755ACDFCA2D13FE4DEE9953D2504FCB4382EEACBCEF90E3E8034BDD32EBA11F1904419DF6AF000053D3029649D2042E160000000000000100A6823403EA3055000000572D3CCDCD01608C31C6187315D600000000A8ED323221608C31C6187315D6708C31C6187315D6010000000000000004535953000000000000";

        String hex = null;

        try {
            hex = abieos.serializePackedTransaction(json);
        } catch (SerializePackedTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void hexToJsonAbiPackedTransaction() {
        String hex = "01001F4D6C791D32E38CA1A0A5F3139B8D1D521B641FE2EE675311FCA4C755ACDFCA2D13FE4DEE9953D2504FCB4382EEACBCEF90E3E8034BDD32EBA11F1904419DF6AF000053D3029649D2042E160000000000000100A6823403EA3055000000572D3CCDCD01608C31C6187315D600000000A8ED323221608C31C6187315D6708C31C6187315D6010000000000000004535953000000000000";
        String jsonResult = "{\"signatures\":[\"SIG_K1_K5PGhrkUBkThs8zdTD9mGUJZvxL4eU46UjfYJSEdZ9PXS2Cgv5jAk57yTx4xnrdSocQm6DDvTaEJZi5WLBsoZC4XYNS8b3\"],\"compression\":0,\"packed_context_free_data\":\"\",\"packed_trx\":\"D3029649D2042E160000000000000100A6823403EA3055000000572D3CCDCD01608C31C6187315D600000000A8ED323221608C31C6187315D6708C31C6187315D6010000000000000004535953000000000000\"}";

        String json = null;

        try {
            json = abieos.deserializePackedTransaction(hex);
        } catch (DeserializePackedTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void jsonToTransactionTrace() {
        String json = "[\"transaction_trace_v0\",{\"id\":\"3098EA9476266BFA957C13FA73C26806D78753099CE8DEF2A650971F07595A69\",\"status\":0,\"cpu_usage_us\":2000,\"net_usage_words\":25,\"elapsed\":\"194\",\"net_usage\":\"200\",\"scheduled\":false,\"action_traces\":[[\"action_trace_v1\",{\"action_ordinal\":1,\"creator_action_ordinal\":0,\"receipt\":[\"action_receipt_v0\",{\"receiver\":\"eosio\",\"act_digest\":\"F2FDEEFF77EFC899EED23EE05F9469357A096DC3083D493571CF68A422C69EFE\",\"global_sequence\":\"11\",\"recv_sequence\":\"11\",\"auth_sequence\":[{\"account\":\"eosio\",\"sequence\":\"11\"}],\"code_sequence\":2,\"abi_sequence\":0}],\"receiver\":\"eosio\",\"act\":{\"account\":\"eosio\",\"name\":\"newaccount\",\"authorization\":[{\"actor\":\"eosio\",\"permission\":\"active\"}],\"data\":\"0000000000EA305500409406A888CCA501000000010002C0DED2BC1F1305FB0FAAC5E6C03EE3A1924234985427B6167CA569D13DF435CF0100000001000000010002C0DED2BC1F1305FB0FAAC5E6C03EE3A1924234985427B6167CA569D13DF435CF01000000\"},\"context_free\":false,\"elapsed\":\"83\",\"console\":\"\",\"account_ram_deltas\":[{\"account\":\"oracle.aml\",\"delta\":\"2724\"}],\"account_disk_deltas\":[],\"except\":null,\"error_code\":null,\"return_value\":\"\"}]],\"account_ram_delta\":null,\"except\":null,\"error_code\":null,\"failed_dtrx_trace\":null,\"partial\":null}]";
        String hexResult = "003098ea9476266bfa957c13fa73c26806d78753099ce8def2a650971f07595a6900d007000019c200000000000000c800000000000000000101010001000000000000ea3055f2fdeeff77efc899eed23ee05f9469357a096dc3083d493571cf68a422c69efe0b000000000000000b00000000000000010000000000ea30550b0000000000000002000000000000ea30550000000000ea305500409e9a2264b89a010000000000ea305500000000a8ed3232660000000000ea305500409406a888cca501000000010002c0ded2bc1f1305fb0faac5e6c03ee3a1924234985427b6167ca569d13df435cf0100000001000000010002c0ded2bc1f1305fb0faac5e6c03ee3a1924234985427b6167ca569d13df435cf01000000005300000000000000000100409406a888cca5a40a000000000000000000000000000000".toUpperCase();
        String hex = null;

        try {
            hex = abieos.serializeTransactionTrace(json);
        } catch (SerializeTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(hex);
        assertEquals(hex, hexResult);
    }

    @Test
    public void jsonToTransactionTraceMsg() {
        String jsonException = "[\"transaction_trace_exception\",{\"error_code\":\"3\",\"error_message\":\"error happens\"}]";
        String jsonTransactionTrace = "[\"transaction_trace\",[\"transaction_trace_v0\",{\"id\":\"B2C8D46F161E06740CFADABFC9D11F013A1C90E25337FF3E22840B195E1ADC4B\",\"status\":0,\"cpu_usage_us\":2000,\"net_usage_words\":12,\"elapsed\":\"7670\",\"net_usage\":\"96\",\"scheduled\":false,\"action_traces\":[[\"action_trace_v1\",{\"action_ordinal\":1,\"creator_action_ordinal\":0,\"receipt\":[\"action_receipt_v0\",{\"receiver\":\"eosio\",\"act_digest\":\"7670940C29EC0A4C573EF052C5A29236393F587F208222B3C1B6A9C8FEA2C66A\",\"global_sequence\":\"27\",\"recv_sequence\":\"1\",\"auth_sequence\":[{\"account\":\"eosio\",\"sequence\":\"2\"}],\"code_sequence\":1,\"abi_sequence\":0}],\"receiver\":\"eosio\",\"act\":{\"account\":\"eosio\",\"name\":\"doit\",\"authorization\":[{\"actor\":\"eosio\",\"permission\":\"active\"}],\"data\":\"00\"},\"context_free\":false,\"elapsed\":\"7589\",\"console\":\"\",\"account_ram_deltas\":[],\"account_disk_deltas\":[],\"except\":null,\"error_code\":null,\"return_value\":\"01FFFFFFFFFFFFFFFF00\"}]],\"account_ram_delta\":null,\"except\":null,\"error_code\":null,\"failed_dtrx_trace\":null,\"partial\":null}]]";
        String hexExceptionResult = "0003000000000000000D6572726F722068617070656E73";
        String hexTransactionTraceResult = "0100B2C8D46F161E06740CFADABFC9D11F013A1C90E25337FF3E22840B195E1ADC4B00D00700000CF61D0000000000006000000000000000000101010001000000000000EA30557670940C29EC0A4C573EF052C5A29236393F587F208222B3C1B6A9C8FEA2C66A1B000000000000000100000000000000010000000000EA3055020000000000000001000000000000EA30550000000000EA30550000000000901D4D010000000000EA305500000000A8ED3232010000A51D00000000000000000000000A01FFFFFFFFFFFFFFFF000000000000";
        String hexException = null;
        String hexTransactionTrace = null;

        try {
            hexException = abieos.serializeTransactionTraceMsg(jsonException);
            hexTransactionTrace = abieos.serializeTransactionTraceMsg(jsonTransactionTrace);
        } catch (SerializeTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(hexException);
        assertNotNull(hexTransactionTrace);
        assertEquals(hexException, hexExceptionResult);
        assertEquals(hexTransactionTrace, hexTransactionTraceResult);
    }

    @Test
    public void hexToJsonAbiTransactionTrace() {
        String hex = "003098ea9476266bfa957c13fa73c26806d78753099ce8def2a650971f07595a6900d007000019c200000000000000c800000000000000000101010001000000000000ea3055f2fdeeff77efc899eed23ee05f9469357a096dc3083d493571cf68a422c69efe0b000000000000000b00000000000000010000000000ea30550b0000000000000002000000000000ea30550000000000ea305500409e9a2264b89a010000000000ea305500000000a8ed3232660000000000ea305500409406a888cca501000000010002c0ded2bc1f1305fb0faac5e6c03ee3a1924234985427b6167ca569d13df435cf0100000001000000010002c0ded2bc1f1305fb0faac5e6c03ee3a1924234985427b6167ca569d13df435cf01000000005300000000000000000100409406a888cca5a40a000000000000000000000000000000".toUpperCase();	        String hexException = "0003000000000000000D6572726F722068617070656E73";
        String jsonResult = "[\"transaction_trace_v0\",{\"id\":\"3098EA9476266BFA957C13FA73C26806D78753099CE8DEF2A650971F07595A69\",\"status\":0,\"cpu_usage_us\":2000,\"net_usage_words\":25,\"elapsed\":\"194\",\"net_usage\":\"200\",\"scheduled\":false,\"action_traces\":[[\"action_trace_v1\",{\"action_ordinal\":1,\"creator_action_ordinal\":0,\"receipt\":[\"action_receipt_v0\",{\"receiver\":\"eosio\",\"act_digest\":\"F2FDEEFF77EFC899EED23EE05F9469357A096DC3083D493571CF68A422C69EFE\",\"global_sequence\":\"11\",\"recv_sequence\":\"11\",\"auth_sequence\":[{\"account\":\"eosio\",\"sequence\":\"11\"}],\"code_sequence\":2,\"abi_sequence\":0}],\"receiver\":\"eosio\",\"act\":{\"account\":\"eosio\",\"name\":\"newaccount\",\"authorization\":[{\"actor\":\"eosio\",\"permission\":\"active\"}],\"data\":\"0000000000EA305500409406A888CCA501000000010002C0DED2BC1F1305FB0FAAC5E6C03EE3A1924234985427B6167CA569D13DF435CF0100000001000000010002C0DED2BC1F1305FB0FAAC5E6C03EE3A1924234985427B6167CA569D13DF435CF01000000\"},\"context_free\":false,\"elapsed\":\"83\",\"console\":\"\",\"account_ram_deltas\":[{\"account\":\"oracle.aml\",\"delta\":\"2724\"}],\"account_disk_deltas\":[],\"except\":null,\"error_code\":null,\"return_value\":\"\"}]],\"account_ram_delta\":null,\"except\":null,\"error_code\":null,\"failed_dtrx_trace\":null,\"partial\":null}]";

        String json= null;

        try {
            json = abieos.deserializeTransactionTrace(hex);
        } catch (DeserializeTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(json);
        assertEquals(json, jsonResult);
    }

    @Test
    public void hexToJsonAbiTransactionTraceMsg() {
        String hexException = "0003000000000000000D6572726F722068617070656E73";
        String hexTransactionTrace = "0100B2C8D46F161E06740CFADABFC9D11F013A1C90E25337FF3E22840B195E1ADC4B00D00700000CF61D0000000000006000000000000000000101010001000000000000EA30557670940C29EC0A4C573EF052C5A29236393F587F208222B3C1B6A9C8FEA2C66A1B000000000000000100000000000000010000000000EA3055020000000000000001000000000000EA30550000000000EA30550000000000901D4D010000000000EA305500000000A8ED3232010000A51D00000000000000000000000A01FFFFFFFFFFFFFFFF000000000000";

        String jsonExceptionResult = "[\"transaction_trace_exception\",{\"error_code\":\"3\",\"error_message\":\"error happens\"}]";
        String jsonTransactionTraceResult = "[\"transaction_trace\",[\"transaction_trace_v0\",{\"id\":\"B2C8D46F161E06740CFADABFC9D11F013A1C90E25337FF3E22840B195E1ADC4B\",\"status\":0,\"cpu_usage_us\":2000,\"net_usage_words\":12,\"elapsed\":\"7670\",\"net_usage\":\"96\",\"scheduled\":false,\"action_traces\":[[\"action_trace_v1\",{\"action_ordinal\":1,\"creator_action_ordinal\":0,\"receipt\":[\"action_receipt_v0\",{\"receiver\":\"eosio\",\"act_digest\":\"7670940C29EC0A4C573EF052C5A29236393F587F208222B3C1B6A9C8FEA2C66A\",\"global_sequence\":\"27\",\"recv_sequence\":\"1\",\"auth_sequence\":[{\"account\":\"eosio\",\"sequence\":\"2\"}],\"code_sequence\":1,\"abi_sequence\":0}],\"receiver\":\"eosio\",\"act\":{\"account\":\"eosio\",\"name\":\"doit\",\"authorization\":[{\"actor\":\"eosio\",\"permission\":\"active\"}],\"data\":\"00\"},\"context_free\":false,\"elapsed\":\"7589\",\"console\":\"\",\"account_ram_deltas\":[],\"account_disk_deltas\":[],\"except\":null,\"error_code\":null,\"return_value\":\"01FFFFFFFFFFFFFFFF00\"}]],\"account_ram_delta\":null,\"except\":null,\"error_code\":null,\"failed_dtrx_trace\":null,\"partial\":null}]]";

        String jsonException = null;
        String jsonTransactionTrace = null;

        try {
            jsonException = abieos.deserializeTransactionTraceMsg(hexException);
            jsonTransactionTrace = abieos.deserializeTransactionTraceMsg(hexTransactionTrace);
        } catch (DeserializeTransactionError err) {
            err.printStackTrace();
        }

        assertNotNull(jsonException);
        assertNotNull(jsonTransactionTrace);
        assertEquals(jsonException, jsonExceptionResult);
        assertEquals(jsonTransactionTrace, jsonTransactionTraceResult);
    }

    // Direct comparison of the JSON strings is fragile.  This compares the expected JSON to a result by checking
    // that its keys are a sub-set of the results keys since abieos can add keys for empty values.  Values are not
    // included since they can be anything and are not comparable.  If abieos gets the keys right, that is
    // good enough for the unit test.
    public boolean isJsonSubset(String expected, String result) {
        if(expected == null || result == null) {
            return false;
        }
        try {
            JsonParser parser = new JsonParser();
            JsonElement expectedElements = parser.parse(expected);
            JsonElement subsetElements = parser.parse(result);
            JsonObject expectedObject = expectedElements.getAsJsonObject();
            JsonObject subsetObject = subsetElements.getAsJsonObject();
            Set<String> expectedKeySet = expectedObject.keySet();
            Set<String> subsetKeySet = subsetObject.keySet();
            return subsetKeySet.containsAll(expectedKeySet);
        } catch (Exception err) {
            return false;
        }
    }
}