            Class<Inner> innerClz = Inner.class;
            Class<Inner.Private> innerPriClz = Inner.Private.class;
            Object inner = innerClz.newInstance();

            Constructor<Inner.Private> ctor = (Constructor<Inner.Private>) innerPriClz.getDeclaredConstructors()[0];
            ctor.setAccessible(true);

            Inner.Private p =  ctor.newInstance(inner);
            o = p;