package de.openknowledge.jaxrs.reactive.ServletInputStreamPublisherAdapterTest;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import de.openknowledge.jaxrs.reactive.ServletInputStreamPublisherAdapter;
import de.openknowledge.jaxrs.reactive.flow.BufferedSubscriber;

@Ignore("FIXME")
@RunWith(MockitoJUnitRunner.class)
public class ServletInputStreamPublisherAdapterTest {

  @Mock
  private ServletInputStream servletInputStreamMock;

  @InjectMocks
  private ServletInputStreamPublisherAdapter servletInputStreamPublisherAdapter;

  @Test public void whenSubscribeExpectOnSubscribeCalledOnSubscriber() throws Exception {

  }

  /**
   * TBD
   * @throws Exception
   */
  @Test public void whenDataAvailableExpectReadBytesPublishedToSubscriber() throws Exception {

    List<Byte> expectedValues = Arrays.asList((byte)2, (byte)47);

    AnswerArg1<ReadListener> answer = new AnswerArg1<>();

    BufferedSubscriber<byte[]> bufferedSubscriber = new BufferedSubscriber<>();

    // mock setup
    // receive setReadListener's argument
    Mockito
      .doAnswer(answer)
      .when(servletInputStreamMock).setReadListener(Mockito.any(ReadListener.class));

    // return one byte on ServletInputStream.read
    when(servletInputStreamMock.read())
      .thenReturn(2)
      .thenReturn(47);

    when(servletInputStreamMock.isReady())
      .thenReturn(true)
      .thenReturn(true)
      .thenReturn(false);

    servletInputStreamPublisherAdapter.startReading();
    servletInputStreamPublisherAdapter.subscribe(bufferedSubscriber);

    // inform about data availability
    answer.getArg().onDataAvailable();

    // asserts
    List<byte[]> receivedByteList = bufferedSubscriber.toList();
    Assert.assertThat(receivedByteList.size(), CoreMatchers.equalTo(2));
//    Assert.assertThat(receivedByteList, CoreMatchers.hasItem((byte)2));
//    Assert.assertThat(receivedByteList, CoreMatchers.hasItem((byte)47));
  }

  @Test public void whenNoMoreDataAvailableOnCompletedCalled() throws Exception {

    AnswerArg1<ReadListener> answer = new AnswerArg1<>();

    BufferedSubscriber<Object> bufferedSubscriber = new BufferedSubscriber<>();

    // mock setup
    // receive setReadListener's argument
    Mockito
      .doAnswer(answer)
      .when(servletInputStreamMock).setReadListener(Mockito.any(ReadListener.class));

    // return one byte on ServletInputStream.read
    when(servletInputStreamMock.read())
      .thenReturn(-1);

    when(servletInputStreamMock.isReady())
      .thenReturn(true);

    servletInputStreamPublisherAdapter.startReading();
    servletInputStreamPublisherAdapter.subscribe(bufferedSubscriber);

    // inform about data availability
    answer.getArg().onDataAvailable();

    // asserts
    Assert.assertThat(bufferedSubscriber.isCompleted(), CoreMatchers.equalTo(true));
  }

  @Test public void whenIoExceptionThrownOnReadExpectOnErrorCalled() throws Exception {
    IOException expectedException = new IOException();

    AnswerArg1<ReadListener> answer = new AnswerArg1<>();

    BufferedSubscriber<Object> bufferedSubscriber = new BufferedSubscriber<>();

    // mock setup
    // receive setReadListener's argument
    Mockito
      .doAnswer(answer)
      .when(servletInputStreamMock).setReadListener(Mockito.any(ReadListener.class));

    // return one byte on ServletInputStream.read
    when(servletInputStreamMock.read())
      .thenThrow(expectedException);

    when(servletInputStreamMock.isReady())
      .thenReturn(true);

    servletInputStreamPublisherAdapter.startReading();
    servletInputStreamPublisherAdapter.subscribe(bufferedSubscriber);

    // inform about data availability
    answer.getArg().onDataAvailable();

    // asserts
    Assert.assertThat(bufferedSubscriber.getException(), CoreMatchers.equalTo(expectedException));
  }
}
