package com.cydeo.jkws;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Map;

public class JwkExample {

    public static void main(String[] args) {
        String jwkSetJson = """
                {
                    "keys": [
                        {
                            "kty": "RSA",
                            "n": "ptn-M5-rHpseIcib8jMDTMYTGTFX3OE3AWKky8mTdiNRF2CUl47LSgSWGdTAYZ7PaJc03yAnKfIZV48MXbzPGoO9kSXDeyyxLbzX7o71WJAClJs_NrwX73hinW2mwfZ_0dfD3KZPdDBcTjlbPh0GP_2up2l8FDfYUDYpe1w4OoIo-x2hZfXpqfYDLBK2pnURJUwAX7VC5a8aZ2W-5SqFUIu0UhgTFRVLk5nC4rKoN8G6EuQ5Vm7xVgU3EHwP-iNnjlSkOWOQG8wIQFiQdLAYIZO3CGit9dzH5Hf-ovjaE5y7TiB0vpCIn9F9hs8PDdurLga_EjrEfT_y3Q0ib1-Y6n_hbzPwBxADbl4wxk7USpahqa00TXgBQYDxJmhJokl8RCDN37hilPDATiURbv_1EnvdzO63_gKUSbK2hS3lArrYscIvmZYBbGLFKE4woslynGBk5qX0ffvKhlflqR_eDmNba9HCksKNefEHKCDzTDOLoEGBKl2rZcwheBcQvbagbiM-1NrACrAcgnv5HpHOkC82z65_kevkdvcekHznhokkFUjsQ5DDHA3dEPFNd7YbCxkNHIXbTjKKGzk5KC4xlIjt_hM6tQydMjVCiiCc_9PGtoYgXsvqtxrVWgEGEArVsADL_d1oqY--223sU6DnW-tp3hcdRks0lLpe0TkolwM",
                            "e": "AQAB",
                            "kid": "c4063389108b2a2cdf3510c0140c08c2",
                            "use": "sig",
                            "alg": "RS256"
                        }
                    ]
                }""";

        SigningKeyResolver resolver = new SigningKeyResolverAdapter() {
            @Override
            public Key resolveSigningKey(JwsHeader header, Claims claims) {
                String kid = header.getKeyId();
                Map<String, Object> jwk = findJwkById(kid, jwkSetJson);
                try {
                    byte[] nBytes = Base64.getUrlDecoder().decode((String) jwk.get("n"));
                    byte[] eBytes = Base64.getUrlDecoder().decode((String) jwk.get("e"));

                    BigInteger n = new BigInteger(1, nBytes);
                    BigInteger e = new BigInteger(1, eBytes);

                    RSAPublicKeySpec spec = new RSAPublicKeySpec(n, e);
                    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                    return keyFactory.generatePublic(spec);
                } catch (Exception ex) {
                    throw new RuntimeException("Failed to create RSA key", ex);
                }
            }

            private Map<String, Object> findJwkById(String kid, String jwkSetJson) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode jwks = mapper.readTree(jwkSetJson);
                    for (JsonNode key : jwks.get("keys")) {
                        if (key.get("kid").asText().equals(kid)) {
                            return mapper.convertValue(key, Map.class);
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Failed to parse JWK Set", e);
                }
                return null;
            }
        };

        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImM0MDYzMzg5MTA4YjJhMmNkZjM1MTBjMDE0MGMwOGMyIn0.eyJodHRwczovL2xlZ2FjeS1hdXRoLmRhdC5jb20vc2Vzc2lvbiI6Ikg0c0lBQUFBQUFBQUFIVlNYV3ZiTUJUOUsrWStlMEx5aDJ6bmFZazN0a0tibFNhd1F1bUQ2aWlkdTBRMmtweXRLL252UFhKU3hqWVBCUGRENXg2ZGUzVmZ5QTBQam1aMzlLUU9pZzIrM2JHNXRlcjVzbldlNGp1cWwreDJ5U3JCZVZhVUZOTjF6UzZ2RU9lU0oyTzhaSXRQcDNzcEVhOHZXSjJmOFNuZDM4ZWthVWJPcTBlTjI2YmQwS3pJczFJa01YVWhLR1dhRkdsTWp5SGdRS2czcHprN1E3QnBLbEloWlV3N3NHMzdIMC9Wem9qaHU5b2V3RHFXaUt5U3NvekpoWUNpQ0huM2tJUWdLZklrSzhBNFBpZ1FaakhaM1loYnNWTWRPNEdDeE0zL0xnWk1aSmJEZ1FIZEFJTXVsQUY2YlpWeFRXZDFWSGZHNko5dFo2SVArcUIzWGIvWHhrZHI3WHdrUU5MM05IdEJiOUNCVXBpY28zbFF5Q3pOME9RUjg5cURVRm4vWHBuV3FuMXJHdFowK3lEZ1ZOWGp1MlNGb24yZ2FrMEwrTTNIMVhwK2ZURTRiUUhjQmtuenNacEFxRFlCR01TVHdML3dhUFUxV25tci9PQmdjWFNVY0U2bnhtaWgxVUZiMzVrd1FLaWxMemZ3ZnNHcENzN0xkNFhnOGswTXlIMlA5ekYyMjR5ZlpTME1nNE8xV2p6WGFtelhQL2RoQ1g1djJHZmx2bDNoTHFhcUN0UDdZMmRpRWpKRjl1L05FaVdmd29weUtsc21Vd3pWSkZaTWFrakNhL01WcTIvUDJYek1pcW1zK0ZmWjhmZ0tyUFdleEZzREFBQT0iLCJodHRwczovL2xlZ2FjeS1hdXRoLmRhdC5jb20vdXNlcm9yZyI6IjMzMTMxNjZ8MHw4NjMyNzN8NzU0ODEyfDEyNzU0IiwiaHR0cHM6Ly9sZWdhY3ktYXV0aC5kYXQuY29tL2NhcGFiaWxpdGllcyI6IlhQOS8vL3AzM3dYdVh3Z0FXR0Q4QS96azcvRGZIRlpCMEl6L1BjREZDQT09IiwiaHR0cHM6Ly9kYXQuY29tL3Blcm1pc3Npb25zIjpbIkVOQUJMRV9SQVRFX0xPT0tVUF9BUEkiLCJGcmVpZ2h0OkFtZW5pdGllc01hcDpSZWFkIiwiRnJlaWdodDpMb2FkU2VhcmNoZXM6TWFuYWdlIiwiRnJlaWdodDpQcml2YXRlTmV0d29ya1F1ZXJ5TWF0Y2hlczpSZWFkIiwiRnJlaWdodDpQcml2YXRlTmV0d29ya1F1ZXJ5TG9hZE1hdGNoZXM6UmVhZCIsIlZpc2liaWxpdHk6U2hpcG1lbnRSZXF1ZXN0UmVzcG9uc2U6Q3JlYXRlIiwiVmlzaWJpbGl0eTpBc3NpZ25lZFNoaXBtZW50czpSZWFkIiwiVmlzaWJpbGl0eTpTaGlwbWVudFRyYWNraW5nUmVjb3JkOkNyZWF0ZSJdLCJodHRwczovL2RhdC5jb20vdXNlcm9yZyI6IjczZDZjZjNjLWExNmQtNGMzOC04Yjg4LThmMmRjNGNmZDdjZnw2MGQwNDY2NC00NDYyLTRmMGQtODJiOC02NTJlNDAwYjc0MDR8NjBkMDQ2NjQtNDQ2Mi00ZjBkLTgyYjgtNjUyZTQwMGI3NDA0fCIsImh0dHBzOi8vZGF0LmNvbS9pc3N1ZWRUb1NlcnZpY2VBY2NvdW50IjoiMzhmZjg4NDgtM2MzMC00MDlkLThiMGQtNzM2NWEwMDYzOWQzIiwic3ViIjoiYXV0aDB8NjY4YzAyZWI5OTNlMzVhOTU0NDVmNmE5IiwiaWF0IjoxNzIwNjY3MTM1LCJleHAiOjE3MjA2Njg5MzUsImF1ZCI6WyJodHRwczovL3N0YWdpbmctYXBpLmRhdC5jb20iXSwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS5hcGkuc3RhZ2luZy5kYXQuY29tL2FjY2Vzcy8ifQ.m1ZA57pp7_T9DGZfJi5qK2zXZ5jAiYfdrfi_PWBmKGJqTY3WfYVnkcv8-UoFjw47oGlYFVWrjtNUjBfETIGS7cIlwYN9Nq0Zbmk6SCmYIAtpPoj-moF3wSo-ohmBWEHsiNLS268ZVHn2VcV8NeEGspHZIA1KxjBZ8LGfhOC6XC3R7odaiqm9PnU7AF7IDotdBmsiP_JzmMceqT21713yu7xfobRU6R6s8Vq39IQss4x8JDU4FTm5Lm26kArNohZFwY70AQEFN4eUYpxSvFAQlj4odrONYwNwOY_OsQlgdUHOQ_pBrio0202DtXJ9MRvHqxXYSQw48wkWLIyf-lsUFMkK3ylq5vSQPCESz0_VaxsmWkEApVIXm2stG1AJ-CN5SV8vpGrpOXCf4Uh9CC3i85swRYqYXuWxdhPUYSagZEcjcA9t-Lj2JMaNiAPMi9uJs4SjRoYDE1S2hjQ0GzLgiVjWRiZkVv2Hbf_8TqPzqZNlf_DBUByzRxUM-TN4UVsSsTclM6u5CXMzo99Ix535M1SRoANaHDKTwW-uABY3PVtqm0fJMUIX9rmc93UlP40SHrVQ4eiFi6EG9_qmupws1KAS-dALZGL9T1pxe7OGFvYmu_cphTs9xzVdoxOn0AoiaR2svA_HTu7BIEGBiPtxE_7c_MCpB8zj0VmviC3l5Os";
        Jws<Claims> claims = Jwts.parserBuilder().setSigningKeyResolver(resolver).build().parseClaimsJws(jwt);

        System.out.println(claims.getBody());
    }
}