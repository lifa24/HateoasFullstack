import React, { Component } from "react";
import AddButton from "./AddButton";
import Capability from "./Capability";
import { connect } from "react-redux";
import { getAllCapabilities } from "../../actions/CapabilityActions";
import PropTypes from "prop-types";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getAllCapabilities();
  }

  render() {
    return (
      <React.Fragment>
        <AddButton />
        <Capability />
        <Capability />
        <Capability />
      </React.Fragment>
    );
  }
}

Dashboard.propTypes = {
  getAllCapabilities: PropTypes.func.isRequired,
  capabilities: PropTypes.array.isRequired
};

const mapStateToProps = state => ({
  capabilities: state.capability.capabilities
});

export default connect(
  mapStateToProps,
  { getAllCapabilities }
)(Dashboard);
