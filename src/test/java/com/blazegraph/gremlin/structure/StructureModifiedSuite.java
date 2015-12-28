package com.blazegraph.gremlin.structure;

import static org.junit.Assert.assertEquals;

import org.apache.tinkerpop.gremlin.AbstractGremlinSuite;
import org.apache.tinkerpop.gremlin.AbstractGremlinTest;
import org.apache.tinkerpop.gremlin.ExceptionCoverage;
import org.apache.tinkerpop.gremlin.FeatureRequirement;
import org.apache.tinkerpop.gremlin.FeatureRequirementSet;
import org.apache.tinkerpop.gremlin.algorithm.generator.CommunityGeneratorTest;
import org.apache.tinkerpop.gremlin.algorithm.generator.DistributionGeneratorTest;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalEngine;
import org.apache.tinkerpop.gremlin.structure.EdgeTest;
import org.apache.tinkerpop.gremlin.structure.FeatureSupportTest;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.GraphConstructionTest;
import org.apache.tinkerpop.gremlin.structure.GraphTest;
import org.apache.tinkerpop.gremlin.structure.PropertyTest;
import org.apache.tinkerpop.gremlin.structure.SerializationTest;
import org.apache.tinkerpop.gremlin.structure.TransactionTest;
import org.apache.tinkerpop.gremlin.structure.VariablesTest;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.VertexProperty;
import org.apache.tinkerpop.gremlin.structure.VertexPropertyTest;
import org.apache.tinkerpop.gremlin.structure.VertexTest;
import org.apache.tinkerpop.gremlin.structure.io.IoCustomTest;
import org.apache.tinkerpop.gremlin.structure.io.IoEdgeTest;
import org.apache.tinkerpop.gremlin.structure.io.IoGraphTest;
import org.apache.tinkerpop.gremlin.structure.io.IoPropertyTest;
import org.apache.tinkerpop.gremlin.structure.io.IoTest;
import org.apache.tinkerpop.gremlin.structure.io.IoVertexTest;
import org.apache.tinkerpop.gremlin.structure.util.detached.DetachedEdgeTest;
import org.apache.tinkerpop.gremlin.structure.util.detached.DetachedGraphTest;
import org.apache.tinkerpop.gremlin.structure.util.detached.DetachedPropertyTest;
import org.apache.tinkerpop.gremlin.structure.util.detached.DetachedVertexPropertyTest;
import org.apache.tinkerpop.gremlin.structure.util.detached.DetachedVertexTest;
import org.apache.tinkerpop.gremlin.structure.util.reference.ReferenceEdgeTest;
import org.apache.tinkerpop.gremlin.structure.util.reference.ReferenceGraphTest;
import org.apache.tinkerpop.gremlin.structure.util.reference.ReferenceVertexPropertyTest;
import org.apache.tinkerpop.gremlin.structure.util.reference.ReferenceVertexTest;
import org.apache.tinkerpop.gremlin.structure.util.star.StarGraphTest;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class StructureModifiedSuite extends AbstractGremlinSuite {

    
    /**
     * This list of tests in the suite that will be executed.  Gremlin developers should add to this list
     * as needed to enforce tests upon implementations.
     */
    private static final Class<?>[] allTests = new Class<?>[]{

            ModifiedDetachedGraphTest.class,
            DetachedEdgeTest.class,
            DetachedVertexPropertyTest.class,
            DetachedPropertyTest.class,
            DetachedVertexTest.class,
            EdgeTest.class,
            FeatureSupportTest.class,
            GraphTest.class,
            GraphConstructionTest.class,
            ModifiedVertexPropertyTest.class,
            VariablesTest.class,
            ModifiedPropertyTest.class,
            ReferenceGraphTest.class,
            ReferenceEdgeTest.class,
            ReferenceVertexPropertyTest.class,
            ReferenceVertexTest.class,
            SerializationTest.class,
            ModifiedStarGraphTest.class,
            VertexTest.class,
            ModifiedTransactionTest.class,
            CommunityGeneratorTest.class,
            DistributionGeneratorTest.class,
            IoCustomTest.class,
            IoEdgeTest.class,
            IoGraphTest.class,
            IoVertexTest.class,
            IoPropertyTest.class,
            IoTest.class,
            
    };

    public StructureModifiedSuite(final Class<?> klass, final RunnerBuilder builder) throws InitializationError {
        super(klass, builder, allTests, null, false, TraversalEngine.Type.STANDARD);
    }
    
    public static class ModifiedGraphTest extends GraphTest {

//        /*
//         * Works but takes too long
//         */
//        @Override
//        public void shouldTestTreeConnectivity() {
////            super.shouldTestTreeConnectivity();
//        }
//        
//        /*
//         * Works but takes too long
//         */
//        @Override
//        public void shouldRemoveVertices() {
////            super.shouldRemoveVertices();
//        }
//        
//        /*
//         * Works but takes too long
//         */
//        @Override
//        public void shouldRemoveEdges() {
////            super.shouldRemoveEdges();
//        }
        
    }
    
    public static class ModifiedDetachedGraphTest extends DetachedGraphTest {

        /**
         * Superclass is missing feature requirements that was causing this
         * to run even though Blaze does not support user supplied ids for
         * vertex properties or numeric ids for vertices.
         */
        @Override
        @FeatureRequirement(featureClass = Graph.Features.VertexFeatures.class, feature = Graph.Features.VertexFeatures.FEATURE_NUMERIC_IDS)
        @FeatureRequirement(featureClass = Graph.Features.VertexPropertyFeatures.class, feature = Graph.Features.VertexPropertyFeatures.FEATURE_USER_SUPPLIED_IDS)
        public void testAttachableCreateMethod() {
            super.testAttachableCreateMethod();
        }
        
//        /*
//         * Works but takes too long
//         */
//        @Override
//        public void testAttachableGetMethod() {
////            super.testAttachableGetMethodT();
//        }
        
    }
    
    public static class ModifiedStarGraphTest extends StarGraphTest {
        
        /**
         * Superclass is missing feature requirements that was causing this
         * to run even though Blaze does not support user supplied ids for
         * vertex properties or numeric ids for vertices.
         */
        @Override
        @FeatureRequirement(featureClass = Graph.Features.VertexFeatures.class, feature = Graph.Features.VertexFeatures.FEATURE_NUMERIC_IDS)
        @FeatureRequirement(featureClass = Graph.Features.VertexPropertyFeatures.class, feature = Graph.Features.VertexPropertyFeatures.FEATURE_USER_SUPPLIED_IDS)
        public void shouldAttachWithCreateMethod() {
        }
        
    }
    
    @ExceptionCoverage(exceptionClass = Vertex.Exceptions.class, methods = {
            "multiplePropertiesExistForProvidedKey",
    })
    @RunWith(Enclosed.class)
    public static class ModifiedVertexPropertyTest extends AbstractGremlinTest { // extends VertexPropertyTest {

        public static class ModifiedVertexPropertyProperties extends VertexPropertyTest.VertexPropertyProperties {

            /**
             * Superclass asserts equality between blaze's empty property
             * and EmptyProperty, which is a final class. 
             */
            @Test
            @FeatureRequirementSet(FeatureRequirementSet.Package.VERTICES_ONLY)
            @FeatureRequirement(featureClass = Graph.Features.VertexFeatures.class, feature = Graph.Features.VertexFeatures.FEATURE_META_PROPERTIES)
            public void shouldReturnEmptyIfNoMetaProperties() {
                final Vertex v = graph.addVertex();
                final VertexProperty<String> vp = v.property(VertexProperty.Cardinality.single, "name", "marko");
                assertEquals(EmptyBlazeProperty.instance(), vp.property("name"));
            }
            
        }

        public static class ModifiedVertexPropertyRemoval extends VertexPropertyTest.VertexPropertyRemoval { }

        public static class ModifiedVertexPropertyAddition extends VertexPropertyTest.VertexPropertyAddition { }

        public static class ModifiedBasicVertexProperty extends VertexPropertyTest.BasicVertexProperty { }

    }

    @RunWith(Enclosed.class)
    public static class ModifiedPropertyTest /* extends PropertyTest */ {

        /**
         * Basic tests for the {@link org.apache.tinkerpop.gremlin.structure.Property} class.
         */
        public static class ModifiedBasicPropertyTest extends PropertyTest.BasicPropertyTest {

            /**
             * Superclass asserts equality between blaze's empty vertex property
             * and EmptyVertexProperty, which is a final class. 
             */
            @Test
            @FeatureRequirementSet(FeatureRequirementSet.Package.VERTICES_ONLY)
            public void shouldReturnEmptyPropertyIfKeyNonExistent() {
                final Vertex v = graph.addVertex("name", "marko");
                tryCommit(graph, (graph) -> {
                    final Vertex v1 = graph.vertices(v.id()).next();
                    final VertexProperty p = v1.property("nonexistent-key");
                    assertEquals(EmptyBlazeVertexProperty.instance(), p);
                });
            }
            
        }
        
        public static class ModifiedPropertyFeatureSupportTest extends PropertyTest.PropertyFeatureSupportTest { }

        public static class ModifiedPropertyValidationOnAddExceptionConsistencyTest extends PropertyTest.PropertyValidationOnAddExceptionConsistencyTest { }

        public static class ModifiedElementGetValueExceptionConsistencyTest extends PropertyTest.ElementGetValueExceptionConsistencyTest { }

        public static class ModifiedPropertyValidationOnSetExceptionConsistencyTest extends PropertyTest.PropertyValidationOnSetExceptionConsistencyTest { }

    }

    /**
     * These three tests attempt to access the unisolated connection from
     * another thread.  
     * 
     * @author mikepersonick
     */
    public static class ModifiedTransactionTest extends TransactionTest {
        
        public void shouldAllowReferenceOfVertexIdOutsideOfOriginalThreadManual() throws Exception {
//            super.shouldAllowReferenceOfVertexIdOutsideOfOriginalThreadManual();
        }
        
        public void shouldAllowReferenceOfEdgeIdOutsideOfOriginalThreadManual() throws Exception {
//            super.shouldAllowReferenceOfEdgeIdOutsideOfOriginalThreadManual();
        }
        
        public void shouldSupportTransactionIsolationCommitCheck() throws Exception {
//            super.shouldSupportTransactionIsolationCommitCheck();
        }
        
    }
        
}