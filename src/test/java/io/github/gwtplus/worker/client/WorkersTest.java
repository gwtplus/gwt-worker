package io.github.gwtplus.worker.client;

import static com.google.common.truth.Truth.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorkersTest {
  
  @Mock
  WorkersImpl impl;
  
  @Before
  public void setUp() {
    Workers.setImpl(impl);
  }

  @Test
  public void getScope_InWorker() throws Exception {
    //given
    WorkerScope expected = mock(WorkerScope.class);
    
    when(impl.inWorker()).thenReturn(true);
    when(impl.getScope()).thenReturn(expected);
    
    //when
    WorkerScope actual = Workers.getScope();
    
    //then
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test
  public void getScope_NotInWorker() throws Exception {
    //given
    
    //when
    try {
      Workers.getScope();
    } catch (RuntimeException e) {
      
      //then
      assertThat(e).isInstanceOf(UnsupportedOperationException.class);
    }
  }

}
