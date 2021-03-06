package de.openknowledge.jaxrs.reactive.converter;

import org.junit.Before;

/**
 * @author Robert Zilke - open knowledge GmbH
 */
public class JsonConverterTest {

  private JsonConverter jsonConverter;

  @Before
  public void setUp()
      throws Exception {

    jsonConverter = new JsonConverter();
  }

//  @Test
//  public void testSimpleObjectsOneArray()
//      throws Exception {
//
//    final boolean[] onCompleteInvoked = {false};
//
//    List<String> items = new ArrayList<>();
//
//    jsonConverter.subscribe(new AbstractSubscriber<>() {
//
//      @Override
//      public void onNext(String item) {
//
//        items.add(item);
//      }
//
//      @Override
//      public void onComplete() {
//
//        onCompleteInvoked[0] = true;
//      }
//    });
//
//    jsonConverter.onNext(
//        "[{\"firstName\":\"Elvis\",\"lastName\":\"Presley\"},{\"firstName\":\"Peter\",\"lastName\":\"Lustig\"}]"
//            .getBytes(StandardCharsets.UTF_8));
//    jsonConverter.onComplete();
//
//    assertEquals(2, items.size());
//
//    assertEquals("{\"firstName\":\"Elvis\",\"lastName\":\"Presley\"}", items.get(0));
//    assertEquals("{\"firstName\":\"Peter\",\"lastName\":\"Lustig\"}", items.get(1));
//
//    assertTrue(onCompleteInvoked[0]);
//  }

//  @Test
//  public void testSimpleObjectsMultipleArrays()
//    throws Exception {
//
//    final boolean[] onCompleteInvoked = {false};
//
//    List<String> items = new ArrayList<>();
//
//    jsonConverter.subscribe(new AbstractSubscriber<>() {
//
//      @Override
//      public void onNext(String item) {
//
//        items.add(item);
//      }
//
//      @Override
//      public void onComplete() {
//
//        onCompleteInvoked[0] = true;
//      }
//    });
//
//    jsonConverter.onNext("[{\"firstName\":\"Elv".getBytes(StandardCharsets.UTF_8));
//    jsonConverter.onNext("is\",\"lastName\":\"Pres".getBytes(StandardCharsets.UTF_8));
//    jsonConverter.onNext("ley\"},{\"firstName\":\"Pe".getBytes(StandardCharsets.UTF_8));
//    jsonConverter.onNext("ter\",\"lastName\":\"Lus".getBytes(StandardCharsets.UTF_8));
//    jsonConverter.onNext("tig\"}]".getBytes(StandardCharsets.UTF_8));
//    jsonConverter.onComplete();
//
//    assertEquals(2, items.size());
//
//    assertEquals("{\"firstName\":\"Elvis\",\"lastName\":\"Presley\"}", items.get(0));
//    assertEquals("{\"firstName\":\"Peter\",\"lastName\":\"Lustig\"}", items.get(1));
//
//    assertTrue(onCompleteInvoked[0]);
//  }

//  @Test
//  public void testSingleBytes()
//    throws Exception {
//
//    final boolean[] onCompleteInvoked = {false};
//
//    List<String> items = new ArrayList<>();
//
//    jsonConverter.subscribe(new AbstractSubscriber<>() {
//
//      @Override
//      public void onNext(String item) {
//
//        items.add(item);
//      }
//
//      @Override
//      public void onComplete() {
//
//        onCompleteInvoked[0] = true;
//      }
//    });
//
//    byte[] bytes = "[{\"firstName\":\"Elvis\",\"lastName\":\"Presley\"}]".getBytes(StandardCharsets.UTF_8);
//
//    for (byte aByte : bytes) {
//      jsonConverter.onNext(new byte[]{aByte});
//    }
//    jsonConverter.onComplete();
//
//    assertEquals(1, items.size());
//    assertEquals("{\"firstName\":\"Elvis\",\"lastName\":\"Presley\"}", items.get(0));
//    assertTrue(onCompleteInvoked[0]);
//  }
}
