package jp.bizreach.twitter.dbflute.allcommon;

import javax.sql.DataSource;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.bhv.core.InvokerAssistant;
import org.seasar.dbflute.bhv.core.supplement.SequenceCacheHandler;
import org.seasar.dbflute.bhv.core.supplement.SequenceCacheKeyGenerator;
import org.seasar.dbflute.cbean.cipher.GearedCipherManager;
import org.seasar.dbflute.cbean.sqlclause.SqlClauseCreator;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import org.seasar.dbflute.exception.factory.SQLExceptionHandlerFactory;
import org.seasar.dbflute.exception.factory.DefaultSQLExceptionHandlerFactory;
import org.seasar.dbflute.exception.thrower.BehaviorExceptionThrower;
import org.seasar.dbflute.jdbc.DataSourceHandler;
import org.seasar.dbflute.jdbc.HandlingDataSourceWrapper;
import org.seasar.dbflute.jdbc.SQLExceptionDigger;
import org.seasar.dbflute.jdbc.StatementConfig;
import org.seasar.dbflute.jdbc.StatementFactory;
import org.seasar.dbflute.optional.RelationOptionalFactory;
import org.seasar.dbflute.outsidesql.factory.DefaultOutsideSqlExecutorFactory;
import org.seasar.dbflute.outsidesql.factory.OutsideSqlExecutorFactory;
import org.seasar.dbflute.resource.ResourceParameter;
import org.seasar.dbflute.helper.beans.factory.DfBeanDescFactory;
import org.seasar.dbflute.s2dao.extension.TnBeanMetaDataFactoryExtension;
import org.seasar.dbflute.s2dao.jdbc.TnStatementFactoryImpl;
import org.seasar.dbflute.s2dao.metadata.TnBeanMetaDataFactory;
import org.seasar.dbflute.twowaysql.factory.DefaultSqlAnalyzerFactory;
import org.seasar.dbflute.twowaysql.factory.SqlAnalyzerFactory;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.framework.util.Disposable;
import org.seasar.framework.util.DisposableUtil;

/**
 * @author DBFlute(AutoGenerator)
 */
public class ImplementedInvokerAssistant implements InvokerAssistant {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected static final String[] DEFAULT_CLIENT_INVOKE_NAMES
        = new String[] { "Page", "Action", "Controller", "ControllerImpl", "Task", "Test" };

    protected static final String[] DEFAULT_BYPASS_INVOKE_NAMES
        = new String[] { "Service", "ServiceImpl", "Facade", "FacadeImpl", "Logic", "LogicImpl" };

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    protected DataSource _dataSource;
    protected DBFluteInitializer _introduction;

    // -----------------------------------------------------
    //                                        Lazy Component
    //                                        --------------
    protected volatile DBMetaProvider _dbmetaProvider;
    protected volatile SqlClauseCreator _sqlClauseCreator;
    protected volatile StatementFactory _statementFactory;
    protected volatile TnBeanMetaDataFactory _beanMetaDataFactory;
    protected volatile SqlAnalyzerFactory _sqlAnalyzerFactory;
    protected volatile OutsideSqlExecutorFactory _outsideSqlExecutorFactory;
    protected volatile SQLExceptionHandlerFactory _sqlExceptionHandlerFactory;
    protected volatile SequenceCacheHandler _sequenceCacheHandler;
    protected volatile RelationOptionalFactory _relationOptionalFactory;

    // -----------------------------------------------------
    //                                       Disposable Flag
    //                                       ---------------
    protected volatile boolean _disposable;

    // ===================================================================================
    //                                                                 Assistant Main Work
    //                                                                 ===================
    // -----------------------------------------------------
    //                                         Current DBDef
    //                                         -------------
    public DBDef assistCurrentDBDef() {
        return DBCurrent.getInstance().currentDBDef();
    }

    // -----------------------------------------------------
    //                                           Data Source
    //                                           -----------
    public DataSource assistDataSource() { // DI component
        // this instance will be cached in SQL executions
        // so the handler should be set before initialization of DBFlute
        // (and it means you cannot switch data source after initialization)
        DataSourceHandler handler = DBFluteConfig.getInstance().getDataSourceHandler();
        return handler != null ? new HandlingDataSourceWrapper(_dataSource, handler) : _dataSource;
    }

    // -----------------------------------------------------
    //                                       DBMeta Provider
    //                                       ---------------
    public DBMetaProvider assistDBMetaProvider() { // lazy component
        if (_dbmetaProvider != null) {
            return _dbmetaProvider;
        }
        synchronized (this) {
            if (_dbmetaProvider != null) {
                return _dbmetaProvider;
            }
            _dbmetaProvider = createDBMetaProvider();
        }
        return _dbmetaProvider;
    }

    protected DBMetaProvider createDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // -----------------------------------------------------
    //                                    SQL Clause Creator
    //                                    ------------------
    public SqlClauseCreator assistSqlClauseCreator() { // lazy component
        if (_sqlClauseCreator != null) {
            return _sqlClauseCreator;
        }
        synchronized (this) {
            if (_sqlClauseCreator != null) {
                return _sqlClauseCreator;
            }
            _sqlClauseCreator = createSqlClauseCreator();
        }
        return _sqlClauseCreator;
    }

    protected SqlClauseCreator createSqlClauseCreator() {
        SqlClauseCreator creator = DBFluteConfig.getInstance().getSqlClauseCreator();
        if (creator != null) {
            return creator;
        }
        return newImplementedSqlClauseCreator(); // as default
    }

    protected ImplementedSqlClauseCreator newImplementedSqlClauseCreator() {
        return new ImplementedSqlClauseCreator();
    }

    // -----------------------------------------------------
    //                                     Statement Factory
    //                                     -----------------
    public StatementFactory assistStatementFactory() { // lazy component
        if (_statementFactory != null) {
            return _statementFactory;
        }
        synchronized (this) {
            if (_statementFactory != null) {
                return _statementFactory;
            }
            _statementFactory = createStatementFactory();
        }
        return _statementFactory;
    }

    protected StatementFactory createStatementFactory() {
        final TnStatementFactoryImpl factory = newStatementFactoryImpl();
        factory.setDefaultStatementConfig(assistDefaultStatementConfig());
        factory.setInternalDebug(DBFluteConfig.getInstance().isInternalDebug());
        factory.setCursorSelectFetchSize(DBFluteConfig.getInstance().getCursorSelectFetchSize());
        return factory;
    }

    protected TnStatementFactoryImpl newStatementFactoryImpl() {
        return new TnStatementFactoryImpl();
    }

    // -----------------------------------------------------
    //                                Bean Meta Data Factory
    //                                ----------------------
    public TnBeanMetaDataFactory assistBeanMetaDataFactory() { // lazy component
        if (_beanMetaDataFactory != null) {
            return _beanMetaDataFactory;
        }
        synchronized (this) {
            if (_beanMetaDataFactory != null) {
                return _beanMetaDataFactory;
            }
            _beanMetaDataFactory = createBeanMetaDataFactory();
        }
        return _beanMetaDataFactory;
    }

    protected TnBeanMetaDataFactory createBeanMetaDataFactory() {
        RelationOptionalFactory relationOptionalFactory = assistRelationOptionalFactory();
        final TnBeanMetaDataFactoryExtension factory = newBeanMetaDataFactoryExtension(relationOptionalFactory);
        factory.setDataSource(_dataSource);
        factory.setInternalDebug(DBFluteConfig.getInstance().isInternalDebug());
        return factory;
    }

    protected TnBeanMetaDataFactoryExtension newBeanMetaDataFactoryExtension(RelationOptionalFactory relationOptionalFactory) {
        return new TnBeanMetaDataFactoryExtension(relationOptionalFactory);
    }

    // -----------------------------------------------------
    //                             Relation Optional Factory
    //                             -------------------------
    /**
     * {@inheritDoc}
     */
    public RelationOptionalFactory assistRelationOptionalFactory() {
        if (_relationOptionalFactory != null) {
            return _relationOptionalFactory;
        }
        synchronized (this) {
            if (_relationOptionalFactory != null) {
                return _relationOptionalFactory;
            }
            _relationOptionalFactory = createRelationOptionalFactory();
        }
        return _relationOptionalFactory;
    }

    protected RelationOptionalFactory createRelationOptionalFactory() {
        return newRelationOptionalFactory();
    }

    protected RelationOptionalFactory newRelationOptionalFactory() {
        return new RelationOptionalFactory();
    }

    // -----------------------------------------------------
    //                                  SQL Analyzer Factory
    //                                  --------------------
    /**
     * {@inheritDoc}
     */
    public SqlAnalyzerFactory assistSqlAnalyzerFactory() { // lazy component
        if (_sqlAnalyzerFactory != null) {
            return _sqlAnalyzerFactory;
        }
        synchronized (this) {
            if (_sqlAnalyzerFactory != null) {
                return _sqlAnalyzerFactory;
            }
            _sqlAnalyzerFactory = createSqlAnalyzerFactory();
        }
        return _sqlAnalyzerFactory;
    }

    protected SqlAnalyzerFactory createSqlAnalyzerFactory() {
        return newDefaultSqlAnalyzerFactory();
    }

    protected DefaultSqlAnalyzerFactory newDefaultSqlAnalyzerFactory() {
        return new DefaultSqlAnalyzerFactory();
    }

    // -----------------------------------------------------
    //                           OutsideSql Executor Factory
    //                           ---------------------------
    /**
     * {@inheritDoc}
     */
    public OutsideSqlExecutorFactory assistOutsideSqlExecutorFactory() {
        if (_outsideSqlExecutorFactory != null) {
            return _outsideSqlExecutorFactory;
        }
        synchronized (this) {
            if (_outsideSqlExecutorFactory != null) {
                return _outsideSqlExecutorFactory;
            }
            _outsideSqlExecutorFactory = createOutsideSqlExecutorFactory();
        }
        return _outsideSqlExecutorFactory;
    }

    protected OutsideSqlExecutorFactory createOutsideSqlExecutorFactory() {
        OutsideSqlExecutorFactory factory = DBFluteConfig.getInstance().getOutsideSqlExecutorFactory();
        if (factory != null) {
            return factory;
        }
        return newDefaultOutsideSqlExecutorFactory(); // as default
    }

    protected DefaultOutsideSqlExecutorFactory newDefaultOutsideSqlExecutorFactory() {
        return new DefaultOutsideSqlExecutorFactory();
    }

    // -----------------------------------------------------
    //                                   SQLException Digger
    //                                   -------------------
    /**
     * {@inheritDoc}
     */
    public SQLExceptionDigger assistSQLExceptionDigger() {
        return createSQLExceptionDigger();
    }

    protected SQLExceptionDigger createSQLExceptionDigger() {
        return DBFluteConfig.getInstance().getSQLExceptionDigger();
    }

    // -----------------------------------------------------
    //                          SQLException Handler Factory
    //                          ----------------------------
    /**
     * {@inheritDoc}
     */
    public SQLExceptionHandlerFactory assistSQLExceptionHandlerFactory() { // lazy component
        if (_sqlExceptionHandlerFactory != null) {
            return _sqlExceptionHandlerFactory;
        }
        synchronized (this) {
            if (_sqlExceptionHandlerFactory != null) {
                return _sqlExceptionHandlerFactory;
            }
            _sqlExceptionHandlerFactory = createSQLExceptionHandlerFactory();
        }
        return _sqlExceptionHandlerFactory;
    }

    protected SQLExceptionHandlerFactory createSQLExceptionHandlerFactory() {
        return newDefaultSQLExceptionHandlerFactory();
    }

    protected DefaultSQLExceptionHandlerFactory newDefaultSQLExceptionHandlerFactory() {
        return new DefaultSQLExceptionHandlerFactory();
    }

    // -----------------------------------------------------
    //                                Sequence Cache Handler
    //                                ----------------------
    /**
     * {@inheritDoc}
     */
    public SequenceCacheHandler assistSequenceCacheHandler() { // lazy component
        if (_sequenceCacheHandler != null) {
            return _sequenceCacheHandler;
        }
        synchronized (this) {
            if (_sequenceCacheHandler != null) {
                return _sequenceCacheHandler;
            }
            _sequenceCacheHandler = createSequenceCacheHandler();
        }
        return _sequenceCacheHandler;
    }

    protected SequenceCacheHandler createSequenceCacheHandler() {
        SequenceCacheHandler handler = newSequenceCacheHandler();
        SequenceCacheKeyGenerator generator = DBFluteConfig.getInstance().getSequenceCacheKeyGenerator();
        if (generator != null) {
            handler.setSequenceCacheKeyGenerator(generator);
        }
        handler.setInternalDebug(DBFluteConfig.getInstance().isInternalDebug());
        return handler;
    }

    protected SequenceCacheHandler newSequenceCacheHandler() {
        return new SequenceCacheHandler();
    }

    // -----------------------------------------------------
    //                                     SQL File Encoding
    //                                     -----------------
    public String assistSqlFileEncoding() {
        return "UTF-8";
    }

    // -----------------------------------------------------
    //                               Statement Configuration
    //                               -----------------------
    public StatementConfig assistDefaultStatementConfig() {
        return DBFluteConfig.getInstance().getDefaultStatementConfig();
    }

    // -----------------------------------------------------
    //                            Behavior Exception Thrower
    //                            --------------------------
    public BehaviorExceptionThrower assistBehaviorExceptionThrower() {
        return new BehaviorExceptionThrower();
    }

    // -----------------------------------------------------
    //                                 Geared Cipher Manager
    //                                 ---------------------
    public GearedCipherManager assistGearedCipherManager() {
        return DBFluteConfig.getInstance().getGearedCipherManager();
    }

    // -----------------------------------------------------
    //                                    Resource Parameter
    //                                    ------------------
    public ResourceParameter assistResourceParameter() {
        return createResourceParameter();
    }

    protected ResourceParameter createResourceParameter() {
        ResourceParameter parameter = newResourceParameter();
        parameter.setOutsideSqlPackage(DBFluteConfig.getInstance().getOutsideSqlPackage());
        parameter.setLogDateFormat(DBFluteConfig.getInstance().getLogDateFormat());
        parameter.setLogTimestampFormat(DBFluteConfig.getInstance().getLogTimestampFormat());
        parameter.setInternalDebug(DBFluteConfig.getInstance().isInternalDebug());
        return parameter;
    }

    protected ResourceParameter newResourceParameter() {
        return new ResourceParameter();
    }

    // -----------------------------------------------------
    //                                          Invoke Names
    //                                          ------------
    public String[] assistClientInvokeNames() {
        return DEFAULT_CLIENT_INVOKE_NAMES;
    }

    public String[] assistByPassInvokeNames() {
        return DEFAULT_BYPASS_INVOKE_NAMES;
    }

    // ===================================================================================
    //                                                                             Dispose
    //                                                                             =======
    public void toBeDisposable(final DisposableProcess callerProcess) { // for HotDeploy
        if (_disposable) {
            return;
        }
        synchronized (this) {
            if (_disposable) {
                return;
            }
            DisposableUtil.add(new Disposable() {
                public void dispose() {
                    callerProcess.dispose();
                    _disposable = false;
                }
            });
            DisposableUtil.add(new Disposable() {
                public void dispose() {
                    DfBeanDescFactory.clear();
                }
            });
            _disposable = true;
        }
    }

    public boolean isDisposable() {
        return _disposable;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public void setDataSource(DataSource dataSource) {
        _dataSource = dataSource;
    }

    // to check the initializer is an instance of DBFluteInitializer
    // when the initializer is extended by DBFlute property
    // so this variable is actually unused in this class
    // (needs to be injected only when the DI container
    // is set by its DI setting file)
    @Binding(bindingType=BindingType.MUST)
    public void setIntroduction(DBFluteInitializer introduction) {
        _introduction = introduction;
    }
}
