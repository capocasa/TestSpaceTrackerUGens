TestPlayBufT : UnitTest {
  
  var
    s
  ;
  
  setUp {
    s = Server.default;
    this.bootServer(s);
  }

  tearDown {
    Buffer.freeAll;
    s.freeAll;
    s.newBusAllocators;
    s.sync;
  }

  test_play {
  
    var bufferS, synth, buffer, data, datar;

    data = [ 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05 ]
;

    SynthDef(\TestPlayBufT, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control, rec;
      control = PlayBufT.kr(2, bufferS, rate, t_trig, start);
      rec = RecordBuf.kr(control, buffer, run: rate>0, loop:0);
      SendReply.kr(Done.kr(rec), '/TestPlayBufT');
    }).send(s);
    s.sync;

    bufferS = Buffer.loadCollection(s, [
      0.01, 48, 0.01,
      0.02, 49, 0.02,
      0.03, 50, 0.03,
      0.04, 51, 0.04,
      0.05, 52, 0.05,
    ], 3);
    
    buffer = Buffer.alloc(s, 256, 2); 
    
    OSCFunc({
      buffer.loadToFloatArray(action:{|d|
        //d.as(Array).round(0.00001).asCompileString.postln;
        datar = d.as(Array);
      });
    }, '/TestPlayBufT', s.addr).oneShot;
  
    s.sync;

    datar = nil;
    Synth(\TestPlayBufT, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    this.asynchAssert({ datar.notNil }, {
      this.assertEquals(datar.round(0.00001), data.round(0.00001));
    }, "data timeout", 1);
   
  }
  
  test_skip {
  
    var bufferS, synth, buffer, data, datar;

    data = [ 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05 ];

    SynthDef(\TestPlayBufT, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control, rec;
      start  = PlayBuf.kr(1, Array.fill(150, 0).put(15, 0).put(30, 0.12).put(45, 0.02).as(LocalBuf));
      t_trig = PlayBuf.kr(1, Array.fill(150, 0).put(15, 1).put(30,    1).put(45,    1).as(LocalBuf));
      control = PlayBufT.kr(2, bufferS, rate, t_trig, start);
      rec = RecordBuf.kr(control, buffer, run: rate>0, loop:0);
      SendReply.kr(Done.kr(rec), '/TestPlayBufT');
    }).send(s);
    s.sync;

    bufferS = Buffer.loadCollection(s, [
      0.01, 48, 0.01,
      0.02, 49, 0.02,
      0.03, 50, 0.03,
      0.04, 51, 0.04,
      0.05, 52, 0.05,
    ], 3);
    
    buffer = Buffer.alloc(s, 256, 2); 
    
    datar = nil;
    OSCFunc({
      buffer.getn(0, 512, {|d|
        d.round(0.00001).asCompileString.postln;
        datar = d;
      });
    }, '/TestPlayBufT', s.addr).oneShot;
  
    s.sync;

    Synth(\TestPlayBufT, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ datar.notNil }, {
      this.assertEquals(datar.round(0.00001), data.round(0.00001));
    }, "datar timeout", 1);
   
  }

}

TestRecordBufT : UnitTest {
  
  var
    s
  ;
  
  setUp {
    s = Server.default;
    this.bootServer(s);
  }

  tearDown {
  }

  test_record {
  
    var bufferS, synth, buffer, data;
    
    SynthDef(\TestRecordBufT, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control;
      control = PlayBuf.kr(2, buffer, rate, t_trig, start);
      RecordBufT.kr([control], bufferS, rate>0, 2);
    }).send(s);
    s.sync;

    buffer = Buffer.loadCollection(s,
      []
      ++ [48, 0.1].wrapExtend(24)
      ++ [49, 0.2].wrapExtend(2*24)
      ++ [50, 0.3].wrapExtend(3*24)
      ++ [51, 0.4].wrapExtend(4*24)
      ++ [52, 0.5].wrapExtend(5*24)
      ++ [10, 0.05].wrapExtend(5*2) // trigger done, will not be recorded
    , 2);
    
    bufferS = Buffer.alloc(s, 5, 3);
    
    OSCFunc({
      bufferS.getn(0, 15, {|d|
        //d.asCompileString.post;
        data = d;
      });
    }, '/n_end', s.addr).oneShot;
    
    s.sync;
    
    Synth(\TestRecordBufT, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ data.notNil }, {
      //data.asCompileString.post;
      this.assertEquals(data.round(0.00001), [ 0.016000000759959, 48.0, 0.10000000149012, 0.032000001519918, 49.0, 0.20000000298023, 0.048000000417233, 50.0, 0.30000001192093, 0.064000003039837, 51.0, 0.40000000596046, 0.079999998211861, 52.0, 0.5 ].round(0.00001));
    }, "data timeout", 1); 
  }
  
  // Free before RecordBufT is done
  test_cutoff {
  
    var bufferS, synth, buffer, data;
    // DoneAction in PlayBuf, not in RecordBufT
    SynthDef(\TestRecordBufT, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control;
      control = PlayBuf.kr(2, buffer, rate, t_trig, start, 0, 2);
      RecordBufT.kr([control], bufferS, rate>0);
    }).send(s);
    s.sync;
    buffer = Buffer.loadCollection(s,
      []
      ++ [48, 0.1].wrapExtend(24)
      ++ [49, 0.2].wrapExtend(2*24)
      ++ [50, 0.3].wrapExtend(3*24)
      ++ [51, 0.4].wrapExtend(4*24)
      ++ [52, 0.5].wrapExtend(5*24)
    , 2);
    
    bufferS = Buffer.alloc(s, 6, 3);
    
    OSCFunc({
      bufferS.getn(0, 18, {|d|
        //d.asCompileString.post;
        data = d;
      });
    }, '/n_end', s.addr).oneShot;
    
    s.sync;
    Synth(\TestRecordBufT, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ data.notNil }, {
      this.assertEquals(data.round(0.00001), [ 0.016000000759959, 48.0, 0.10000000149012, 0.032000001519918, 49.0, 0.20000000298023, 0.048000000417233, 50.0, 0.30000001192093, 0.064000003039837, 51.0, 0.40000000596046, 0.079999998211861, 52.0, 0.5, 0.0, 0.0, 0.0 ].round(0.00001));
    }, "data timeout", 1); 
  }
  
  test_stop {
  
    var bufferS, synth, buffer, data;
    // DoneAction in PlayBuf, not in RecordBufT
    SynthDef(\TestRecordBufT, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control;
      control = PlayBuf.kr(2, buffer, rate, t_trig, start);
      
      // More test cases: Initial zero, last zero, zero before note end, one after and vise versa
      
      rate = PlayBuf.kr(1, [
        1,1,1,1, 0,1,1,0, 0,0,0,0,

        0,1,1,0, 0,1,1,1, 1,1,1,0,
        0,0,0,0, 0,0,0,0, 1,1,1,1,

        1,
      ].as(LocalBuf));
      RecordBufT.kr([control], bufferS, rate>0, 2);
    }).send(s);
    s.sync;
    buffer = Buffer.loadCollection(s,
      []
      ++ [48, 0.1].wrapExtend(24)
      ++ [49, 0.2].wrapExtend(2*24)
      ++ [50, 0.3].wrapExtend(3*24)
      ++ [51, 0.4].wrapExtend(4*24)
      ++ [52, 0.5].wrapExtend(5*24)
      ++ [10, 0.05].wrapExtend(5*2) // trigger done, will not be recorded
    , 2);
    
    bufferS = Buffer.alloc(s, 5, 3);
    
    OSCFunc({
      bufferS.getn(0, 15, {|d|
        //d.asCompileString.post;
        data = d;
      });
    }, '/n_end', s.addr).oneShot;
    
    s.sync;
    Synth(\TestRecordBufT, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ data.notNil }, {
      this.assertEquals(data.round(0.00001), [ 0.0080000003799796, 48.0, 0.10000000149012, 0.016000000759959, 49.0, 0.20000000298023, 0.048000000417233, 50.0, 0.30000001192093, 0.064000003039837, 51.0, 0.40000000596046, 0.079999998211861, 52.0, 0.5 ].round(0.00001));
    }, "data timeout", 1); 
  }

}

TestBufFramesT : UnitTest {
  var
    s, b, coll, startTime, length, responder, is, shall
  ;
 
  setBuffer {
    b = Buffer.allocTimed(s);
    s.sync;
    b.sendCollection(coll);
    s.sync;
  }

  setUp {
    coll = [1,32,0.5,33,1,34];
    s = Server.default;
    this.bootServer(s);
    this.setBuffer;
    responder = OSCFunc({|msg|
      is = msg[3..]; 
    }, '/TestBufFramesT', s.addr);
    s.sync;
    is = nil;
    s.sync;

  }

  test_basic {
    startTime = 0;
    length = 0;
    shall = [ 3, 0, 0, 0];
    this.assertFrames;
  }
  
  test_pre {
    startTime = 0.5;
    length = 0;
    shall = [ 3, 0, 0.5, 0 ];
    this.assertFrames;
  }

  test_post {
    startTime = 0;
    length = 2.25;
    shall = [ 3, 0, 0, 0.25 ];
    this.assertFrames;
  }
  
  test_prepost {
    startTime = 0.5;
    length = 1.25;
    shall = [ 3, 0, 0.5, 0.75 ];
    this.assertFrames;
  }
  
  test_pre_onnext {
    startTime = 1;
    length = 0;
    shall = [2,1,0,0];
    this.assertFrames;
  }
  
  test_pre_onsecond {
    startTime = 1.5;
    length = 0;
    shall = [1,2,0,0];
    this.assertFrames;
  }
  
  test_pre_onlast {
    startTime = 0;
    length = 1.5;
    shall = [2,0,0,0];
    this.assertFrames;
  }
  
  test_pre_onsecondlast {
    startTime = 0;
    length = 1;
    shall = [1,0,0,0];
    this.assertFrames;
  }
  
  test_samelength {
    startTime = 0;
    length = 3;
    shall = [3,0,0,0];
    this.assertFrames;
  }
  
  test_overlength {
    startTime = 0;
    length = 4;
    shall = [3,0,0,0];
    this.assertFrames;
  }
  
  test_overpre {
    startTime = 0.5;
    length = 4;
    shall = [3,0,0.5,0];
    this.assertFrames;
  }

  test_close {
    startTime = 0.9999999;
    length = 0;
    shall = [ 3, 0, Float.from32Bits(872415232), 0 ];
    this.assertFrames;
    //is[2].as32Bits.postln;
  }

  test_closeover {
    startTime = 1.0000001;
    length = 0;
    shall = [ 2, 1, 0.49999988079071, 0 ];
    this.assertFrames;
  }


  assertFrames {
    {
      SendReply.kr(DC.kr(1), '/TestBufFramesT', BufFramesT.kr(b, 1, startTime, length, 2));
    }.play(s);
    this.asynchAssert({is.notNil},{
      this.assertEquals(is, shall);
    }, "timeout", 1);
  }

  tearDown {
    s.sync;
    responder.free;
  }
}

