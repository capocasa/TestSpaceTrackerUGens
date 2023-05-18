TestPlaySpaceTracker : UnitTest {
  
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

    // A good way to think about this data:
    // Each sample consisting of two array entries
    // represents the condition at the *beginning*
    // of the sample time- so 0 is the time of
    // array indices 0 and 1.
    // It follows that the change happens at the first
    // sample where the time is higher than indicated
    // in the time column of the input data.
    // e.g. the beginning of sample-index 7, array indcies
    // 14 and 15, is 0.00933 seconds after the beginning
    // of playback therefore keeps the values 48 and 0.01.
    // The beginning of sample-index 8, array indices
    // 16 and 17, is at 0.01066 and therefore are the first
    // with the new values of 50 and 0.02.

    data = [ 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 ]
;
    SynthDef(\TestPlaySpaceTracker, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control, rec;
      control = PlaySpaceTracker.kr(2, bufferS, rate, t_trig, start);
      rec = RecordBuf.kr(control, buffer, run: rate>0, loop:0);
      SendReply.kr(Done.kr(rec), '/TestPlaySpaceTracker');
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
    }, '/TestPlaySpaceTracker', s.addr).oneShot;
  
    s.sync;

    datar = nil;
    Synth(\TestPlaySpaceTracker, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    this.asynchAssert({ datar.notNil }, {
      this.indexedDiff(256, data, datar);
      this.assertEquals(datar.round(0.00001), data.round(0.00001));
    }, "data timeout", 1);
   
  }

  indexedDiff {
    arg numFrames, data, datar;
    256.do { |t|
      var a, b, aa, bb;
      a = data[2 * t].round(0.00001);
      aa = data[2 * t + 1].round(0.00001);
      b = datar[2 * t].round(0.00001);
      bb = datar[2 * t + 1].round(0.00001);
      if ((a != b) || (aa != bb)) {
        ["DIFF", t, a, aa, b, bb].postln;
      };
    };
  }

  test_skip {
  
    var bufferS, synth, buffer, data, datar;

    data = [ 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 48.0, 0.01, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 49.0, 0.02, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 50.0, 0.03, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 51.0, 0.04, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 52.0, 0.05, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 ];

    SynthDef(\TestPlaySpaceTracker, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control, rec;
      start  = PlayBuf.kr(1, Array.fill(150, 0).put(15, 0).put(30, 0.12).put(45, 0.02).as(LocalBuf));
      t_trig = PlayBuf.kr(1, Array.fill(150, 0).put(15, 1).put(30,    1).put(45,    1).as(LocalBuf));
      control = PlaySpaceTracker.kr(2, bufferS, rate, t_trig, start);
      rec = RecordBuf.kr(control, buffer, run: rate>0, loop:0);
      SendReply.kr(Done.kr(rec), '/TestPlaySpaceTracker');
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
    }, '/TestPlaySpaceTracker', s.addr).oneShot;
  
    s.sync;

    Synth(\TestPlaySpaceTracker, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ datar.notNil }, {
      this.indexedDiff(256, data, datar);
      this.assertEquals(datar.round(0.00001), data.round(0.00001));
    }, "datar timeout", 1);
   
  }

}

TestRecordSpaceTracker : UnitTest {
  
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
    
    SynthDef(\TestRecordSpaceTracker, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control;
      control = PlayBuf.kr(2, buffer, rate, t_trig, start);
      RecordSpaceTracker.kr([control], bufferS, rate>0, 2);
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
    
    Synth(\TestRecordSpaceTracker, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ data.notNil }, {
      //data.asCompileString.post;
      this.assertEquals(data.round(0.00001), [ 0.016000000759959, 48.0, 0.10000000149012, 0.032000001519918, 49.0, 0.20000000298023, 0.048000000417233, 50.0, 0.30000001192093, 0.064000003039837, 51.0, 0.40000000596046, 0.079999998211861, 52.0, 0.5 ].round(0.00001));
    }, "data timeout", 1); 
  }
  
  // Free before RecordSpaceTracker is done
  test_cutoff {
  
    var bufferS, synth, buffer, data;
    // DoneAction in PlayBuf, not in RecordSpaceTracker
    SynthDef(\TestRecordSpaceTracker, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control;
      control = PlayBuf.kr(2, buffer, rate, t_trig, start, 0, 2);
      RecordSpaceTracker.kr([control], bufferS, rate>0);
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
    Synth(\TestRecordSpaceTracker, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ data.notNil }, {
      this.assertEquals(data.round(0.00001), [ 0.016000000759959, 48.0, 0.10000000149012, 0.032000001519918, 49.0, 0.20000000298023, 0.048000000417233, 50.0, 0.30000001192093, 0.064000003039837, 51.0, 0.40000000596046, 0.079999998211861, 52.0, 0.5, 0.0, 0.0, 0.0 ].round(0.00001));
    }, "data timeout", 1); 
  }
  
  test_stop {
  
    var bufferS, synth, buffer, data;
    // DoneAction in PlayBuf, not in RecordSpaceTracker
    SynthDef(\TestRecordSpaceTracker, {|rate=0, t_trig=0, start=0, buffer, bufferS|
      var control;
      control = PlayBuf.kr(2, buffer, rate, t_trig, start);
      
      // More test cases: Initial zero, last zero, zero before note end, one after and vise versa
      
      rate = PlayBuf.kr(1, [
        1,1,1,1, 0,1,1,0, 0,0,0,0,

        0,1,1,0, 0,1,1,1, 1,1,1,0,
        0,0,0,0, 0,0,0,0, 1,1,1,1,

        1,
      ].as(LocalBuf));
      RecordSpaceTracker.kr([control], bufferS, rate>0, 2);
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
    Synth(\TestRecordSpaceTracker, [\rate, 1, \buffer, buffer.bufnum, \bufferS, bufferS.bufnum], s);
    
    this.asynchAssert({ data.notNil }, {
      this.assertEquals(data.round(0.00001), [ 0.0080000003799796, 48.0, 0.10000000149012, 0.016000000759959, 49.0, 0.20000000298023, 0.048000000417233, 50.0, 0.30000001192093, 0.064000003039837, 51.0, 0.40000000596046, 0.079999998211861, 52.0, 0.5 ].round(0.00001));
    }, "data timeout", 1); 
  }

}

TestSpaceTrackerFrames : UnitTest {
  var
    s, b, coll, startTime, length, responder, is, shall, channels
  ;
 
  setUp {
    s = Server.default;
    this.bootServer(s);
    responder = OSCFunc({|msg|
      is = msg[3..]; 
    }, '/TestSpaceTrackerFrames', s.addr);
    is = nil;
    channels = nil;
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
    shall = [ 3, 0, 0, 0.75 ];
    this.assertFrames;
  }
  
  test_prepost {
    startTime = 0.5;
    length = 1.25;
    shall = [ 3, 0, 0.5, 0.25 ];
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
    shall = [ 2, 1, Float.from32Bits(1056964604), 0 ];
    this.assertFrames;
    //is[2].as32Bits.postln;
  }

  test_firstonly {
    startTime = 0;
    length = 0.5;
    shall = [1, 0, 0, 0.5];
    this.assertFrames;
  }
  
  test_lastonly {
    startTime = 2.125;
    length = 0;
    shall = [ 1, 2, 0.375, 0 ];
    this.assertFrames;
  }

  test_shavefirst {
    startTime = 0.25;
    length = 0.5;
    // Note: This is interesting- the first and last ist the same note, and it is correctly denoted
    // 0.75 long by both first and last.
    shall = [ 1, 0, 0.5, 0.5];
    this.assertFrames;
  }
  
  test_shavelast {
    startTime = 1.75;
    length = 0.25;
    shall = [1, 2, 0.25, 0.25];
    this.assertFrames;
    
    is = nil;
    startTime = 2;
    length = 0.25;
    shall = [1, 2, 0.25, 0.25];
    this.assertFrames;
    
    is = nil;
    startTime = 1.75;
    length = 0.5;
    shall = [1, 2, 0.5, 0.5 ];
    this.assertFrames;
  }
  
  test_shavecenter {
    startTime = 1.125;
    length = 0.25;
    shall = [ 1, 1, 0.25, 0.25 ];
    this.assertFrames;
  }
  
  test_shaveonly {
    coll=[1.5,32];
    startTime = 0.25;
    length = 0.5;
    shall = [ 1, 0, 0.5, 0.5];
    this.assertFrames;
  }
  
  test_zero {
    coll=[];
    startTime = 0.25;
    length = 0.5;
    shall = [ 0, 0, 0, 0];
    this.assertFrames;
    
    is = nil;
    coll=[];
    startTime = 0;
    length = 0.5;
    shall = [ 0, 0, 0, 0];
    this.assertFrames;
    
    is = nil;
    coll=[];
    startTime = 0.25;
    length = 0;
    shall = [ 0, 0, 0, 0];
    this.assertFrames;
    
    is = nil;
    coll=[];
    startTime = 0;
    length = 0;
    shall = [ 0, 0, 0, 0];
    this.assertFrames;
  }

  test_longer {
    coll =  [ 2.3359072208405, 113, 1.3918336629868, 120, 0.6624151468277, 24, 0.37146842479706, 86, 2.7888704538345, 14, 1.9270226955414, 65, 0.98531985282898, 113, 0.64883601665497, 104, 1.8623775243759, 23, 2.4141165018082, 117, 0.029054760932922, 44, 2.6779514551163, 74, 2.3031853437424, 41, 1.8753358125687, 110, 0.081579566001892, 2, 1.5765784978867, 86, 1.5339649915695, 4, 1.2851167917252, 53, 1.9376907348633, 33, 0.8805992603302, 76 ];
    
    startTime = 0;
    length = 0;
    shall = [20,0,0,0];
    this.assertFrames;
    this.assertBoundaries;
    
    is = nil;
    startTime = 17.13719837;
    length = 0;
    shall = [9,11,Float.from32Bits(1064648160),0];
    this.assertFrames;
    this.assertBoundaries;
    //is[2].as32Bits.postln;
     
    is = nil;
    startTime = 0;
    length = 9.1243213421421;
    shall = [6,0,0,Float.from32Bits(1070166820)];
    this.assertFrames;
    //is[3].as32Bits.postln;
    this.assertBoundaries;

    is = nil;
    startTime = 11.622335910797;
    length = 9.1353964805603;
    shall = [6,8,Float.from32Bits(1068303616),Float.from32Bits(1052246016)];
    this.assertFrames;
    //is[2].as32Bits.postln;
    //is[3].as32Bits.postln;
    this.assertBoundaries;
  
  }

  test_multichannel_long {
    coll = [ 9.1337192058563, 17, 20, 97, 6.399017572403, 37, 101, 92, 4.0919506549835, 71, 69, 97, 4.0838253498077, 27, 6, 114, 8.4694528579712, 37, 47, 3, 0.12431740760803, 91, 69, 25, 8.5956215858459, 1, 2, 33, 1.5181195735931, 90, 18, 96, 5.3417408466339, 95, 101, 22, 5.9933578968048, 64, 58, 43, 6.6469585895538, 49, 120, 56, 9.3143355846405, 50, 81, 117, 2.033303976059, 118, 1, 35, 1.2936115264893, 118, 11, 102, 6.7575621604919, 27, 63, 124, 4.3031942844391, 113, 44, 88, 4.9205708503723, 19, 102, 4, 5.390852689743, 53, 20, 14, 9.8089456558228, 81, 94, 25, 4.6411645412445, 80, 83, 107, 2.2814118862152, 15, 92, 80, 2.0842516422272, 45, 82, 90, 7.6886701583862, 67, 87, 60, 9.4486975669861, 15, 74, 87, 5.8108699321747, 98, 99, 119, 3.7641739845276, 112, 38, 48 ];
    channels=3;
    
    startTime=0;
    length=0;
    shall=[26,0,0,0];
    this.assertFrames;
    this.assertBoundaries;
    
    is=nil;
    startTime=56.31;
    length=0;
    shall=[ 16, 10, Float.from32Bits(1082315144), 0];
    this.assertFrames;
    this.assertBoundaries;
    //is[2].as32Bits.postln;
    
    is=nil;
    startTime=0;
    length=97.13121243;
    shall=[19,0,0,Float.from32Bits(1076760480)];
    this.assertFrames;
    this.assertBoundaries;
    //is[3].as32Bits.postln;

    is=nil;
    startTime=56.31;
    length=32.97;
    shall=[ 8, 10, Float.from32Bits(1082315144), Float.from32Bits(1048889600)];
    this.assertFrames;
    this.assertBoundaries;
    //is[2].as32Bits.postln;
    //is[3].as32Bits.postln;
  }

  assertBoundaries {
    var times, startTimeShall, lengthShall, frames, offset, pre, post;

    #frames,offset,pre,post = shall;

    times = coll.unlace(channels??1+1).first;

    if (startTime > 0) {
      startTimeShall = times[0..offset].put(offset, times[offset]-pre).sum;
    }{
      startTimeShall = 0;
    };
    this.assertEquals(startTime.round(0.0001), startTimeShall.round(0.0001), "start sum");

    if (length > 0) {
      if (startTime > 0) {
        lengthShall = times[offset..offset+frames-1].put(0, pre).put(frames-1, post).sum;
      }{
        lengthShall = times[0..frames-1].put(frames-1,post).sum;
      };
    }{
      lengthShall = 0;
    };
    this.assertEquals(length.round(0.0001), lengthShall.round(0.0001), "length sum"); 
  }

  assertFrames {
    if (coll.isNil) {
      coll = [1,32,0.5,33,1,34];
    };
    b = Buffer.allocSpaceTracker(s,1,channels??1);
    s.sync;
    b.sendCollection(coll);
    s.sync;
    {
      SendReply.kr(DC.kr(1), '/TestSpaceTrackerFrames', BufFramesT.kr(b, 1, startTime, length, 2));
    }.play(s);
    this.asynchAssert({is.notNil},{
      this.assertEquals(is, shall);
    }, "timeout", 1);
  }

  tearDown {
    s.sync;
    responder.free;
    b.free;
    s.sync;
  }
}

TestBufferExtensions : UnitTest {
  
  var
    s, b, p, f, a, c, x
  ;
 
  setUp {
    s = Server.default;
    this.bootServer(s);
    b = Buffer.allocSpaceTracker(s,1,1,128);
    s.sync;
    b.updateInfo;
    s.sync;
    a = 128.collect{|i|i+1/128}.as(Signal);
    b.sendCollection(a);
    s.sync;
    p = thisProcess.platform.defaultTempDir +/+ this.class.name ++2147483647.rand++".aiff";
  }
 
  tearDown {
    b.free;
    File.delete(p);
  }

  test_alloc {
    this.assertEquals(b.class, Buffer, "1-1 class");
    this.assertEquals(b.numChannels, 2, "1-1 numChannels");
    this.assertEquals(b.numFrames, 128, "1-1 numFrames");
    b.free;

    b = Buffer.allocSpaceTracker(s,2,2,128);
    this.assertEquals(b.class, Array, "2-1 class");
    this.assertEquals(b.size, 2, "2-1 size");
    this.assertEquals(b[0].class, Buffer, "2-1 0 class");
    this.assertEquals(b[0].numChannels, 3, "2-1 0 numChannels");
    this.assertEquals(b[1].class, Buffer, "2-1 1 class");
    this.assertEquals(b[1].numChannels, 3, "2-1 1 numChannels");
  }

  test_detect {
    this.assertEquals(b.detectSpaceTracker(0.1,3), [ 17, 3, Float.from32Bits(1020054732), Float.from32Bits(1049572144) ]);
    s.sync;
  }

  test_write {
    b.writeSpaceTracker(p);
    s.sync;
    this.fromFile;
    this.assertEquals(a, c, "entire");
  
    b.writeSpaceTracker(p, "aiff", 0.1, 3);
    this.fromFile;

    x=Signal[ 0.024999998509884, 0.0625, 0.0703125, 0.078125, 0.0859375, 0.09375, 0.1015625, 0.109375, 0.1171875, 0.125, 0.1328125, 0.140625, 0.1484375, 0.15625, 0.1640625, 0.171875, 0.1796875, 0.1875, 0.1953125, 0.203125, 0.2109375, 0.21875, 0.2265625, 0.234375, 0.2421875, 0.25, 0.2578125, 0.265625, 0.2734375, 0.28125, 0.2890625, 0.296875, 0.27968740463257, 0.3125];
    this.assertEquals(x, c, "trimmed");
  
    this.assertEquals(x.unlace(2)[0].sum.round(0.000001), 3, "trimmed sum");
  }

  fromFile {
    f = SoundFile.openRead(p);
    c = Signal.newClear(f.numFrames*f.numChannels);
    f.readData(c);
    f.close;
  }

}

